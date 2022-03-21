package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import dao.AutoreDao;
import dao.LibroDao;
import dto.AutoreDTO;
import dto.LibroDTO;
import mapper.AutoreMapper;
import mapper.LibroMapper;
import model.Autore;
import model.Libro;
import servlet.SimpleInterceptor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LibreriaService {
	
	@Inject
	AutoreDao autoreDao;
	
	@Inject
	AutoreDTO autoreDto;
	
	@Inject
	LibroDao libroDao;
	
	@Inject
	LibroDTO libroDto;
	
//	public List<AutoreDTO> findAll() {
//		List<AutoreDTO> autoriDto = AutoreMapper.INSTANCE.mapToAutoreDto(autoreDao.findAll());
//		
//		return autoriDto;
//	}
	
	@Interceptors(SimpleInterceptor.class)
	public void aggiungiAutore(AutoreDTO autoreDto) {
		Autore autoreNuovo = AutoreMapper.INSTANCE.mapToEntity(autoreDto);
		autoreDao.save(autoreNuovo);
	}
	
	public void eliminaAutore(AutoreDTO autoreDto) {
		Autore autore = AutoreMapper.INSTANCE.mapToEntitywithId(autoreDto);
		autoreDao.delete(autore);
	}
	
	public List<AutoreDTO> trovaAutorePerNome(String nome) {
		List<AutoreDTO> autoriDto = AutoreMapper.INSTANCE.mapToAutoreDto(autoreDao.findAutoriByNome(nome));
		return autoriDto;
	}
	
	public List<LibroDTO> findAllLibri(){
		List<LibroDTO> libriDto = LibroMapper.INSTANCE.mapToLibriDto(libroDao.findAllLibri());
		return libriDto;
	}
	
	public void aggiungiLibro(LibroDTO libroDto) {
		Libro libroNuovo = LibroMapper.INSTANCE.mapToLibroEntity(libroDto);
		Autore autore = autoreDao.findById(libroDto.getAutore().getId());
		
		if(autore != null) {
			libroNuovo.setAutore(autore);
		} else {
			Autore nuovoAutore=AutoreMapper.INSTANCE.mapToEntity(libroDto.getAutore());
			autoreDao.save(nuovoAutore);
			libroNuovo.setAutore(nuovoAutore);
		}
		
		libroDao.save(libroNuovo);
	}
	
	public void eliminaLibro(LibroDTO libroDTO) {
		Libro libro = LibroMapper.INSTANCE.mapToLibroEntity(libroDTO);
		libroDao.delete(libro);
	}
	
	public List<LibroDTO> trovaAutorePerNomeCognome(String nome, String cognome) {
		List<LibroDTO> libriDto = LibroMapper.INSTANCE.mapToLibriDto(libroDao.findLibriByNomeCognomeAutore(nome, cognome));
		
		return libriDto;
	}
	
	public void aggiornaAutore(AutoreDTO autoreDto) {
		Autore autore = AutoreMapper.INSTANCE.mapToEntitywithId(autoreDto);
		autoreDao.update(autore);
	}
	
	public void aggiornaLibro(LibroDTO libroDto) {
		Libro libro = LibroMapper.INSTANCE.mapToLibroEntity(libroDto);
		libroDao.update(libro);
	}
}
