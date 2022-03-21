package servlet;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.AutoreDTO;
import dto.LibroDTO;
import service.LibreriaService;
import service.Service2;

@Stateless
@Path("rest")
public class RestController {
	
	//CRUD add autore, delete autore, findByname, 
		// get all libri, add, delete, getAllLibriByautore, getLibroByTitolo

	@Inject
	private LibreriaService service;
	
	@Inject
	private Service2 service2;
	
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tuttiAutori")
	public Response cercaTuttiAutori(){
		try {
			return Response.status(200).entity(service2.findAll()).build();
		} catch (Exception  e) {
			return Response.status(400).entity("Errore nella ricerca degli autori, " + e.getMessage()).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aggiungiAutore")
	public Response aggiungiAutore(AutoreDTO nuovoAutoreDto) {
		try {
			service.aggiungiAutore(nuovoAutoreDto);
			return Response.status(200).entity("Autore aggiunto").build();
		} catch (Exception e) {
			return Response.status(400).entity("Errore nell'aggiunta dell'autore, " + e.getMessage()).build();
		}
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{nome}")
	public Response cercaAutoriPerNome(@PathParam("nome") String nome) {
		try {
			return Response.status(200).entity(service.trovaAutorePerNome(nome)).build();
		} catch (Exception e) {
			return Response.status(400).entity("Errore nella ricerca degli autori per nome, " + e.getMessage()).build();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminaAutore")
	public Response eliminaAutore(AutoreDTO autoreDto) {
		try {
			service.eliminaAutore(autoreDto);
			return Response.status(200).entity("Autore eliminato").build();
		} catch (Exception e) {
			return Response.status(400).entity("Errore nell'eliminazione dell'autore, " + e.getMessage()).build();
		} 
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tuttiLibri")
	public Response cercaTuttiLibri(){
		try {
			return Response.status(200).entity(service.findAllLibri()).build();
		} catch (Exception e) {
			return Response.status(400).entity("Errore nella ricerca dei libri, " + e.getMessage()).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aggiungiLibro")
	public Response aggiungiLibro(LibroDTO libroDto) {
		try {
			service.aggiungiLibro(libroDto);    
			return Response.status(200).entity("Libro aggiunto").build();	
		} catch (Exception e) {
		    return Response.status(400).entity("Errore nell'aggiunta del libro " +e.getMessage()).build();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminaLibro")
	public Response eliminaLibro(LibroDTO libroDTO) {
		try {
			service.eliminaLibro(libroDTO);
			return Response.status(200).entity("Libro eliminato").build();
		} catch (Exception e) {
			return Response.status(400).entity("Errore nell'eliminazione del libro, " + e.getMessage()).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tuttiLibri/{nome}/{cognome}")
	public Response cercaLibriPerNomeCognomeAutore(@PathParam("nome") String nome, @PathParam("cognome") String cognome) {
		try {
			return Response.status(200).entity(service.trovaAutorePerNomeCognome(nome,cognome)).build();
		} catch (Exception e) {
			return Response.status(400).entity("Errore nella ricerca degli autori per nome e cognome, " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aggiornaAutore")
	public Response aggiornareAutore(AutoreDTO autoreDto) {
		try {
			service.aggiornaAutore(autoreDto);
			return Response.status(200).entity("Autore aggiornato").build();
		} catch (Exception e) {
			return Response.status(400).entity("Errore nell'aggiornamento dell'autore, " + e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aggiornaLibro")
	public Response aggiornaLibro(LibroDTO libroDto) {
		try {
			service.aggiornaLibro(libroDto);
			return Response.status(200).entity("Libro aggiornato").build();
		} catch (Exception e) {
			return Response.status(400).entity("Errore nell'aggiornamento del libro, " + e.getMessage()).build();
		}
	}

}
