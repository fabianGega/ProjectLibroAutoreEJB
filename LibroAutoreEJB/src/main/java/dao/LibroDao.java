package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Libro;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class LibroDao {
	
	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager entityManager;
	
	public List<Libro> findAllLibri() {
		Query query = entityManager.createNativeQuery("select * from Libro", Libro.class);
		
		return query.getResultList();
	}
	
	public List<Libro> trovaLibriByIdAutore(int autoreId){ 
		Query query = entityManager.createNativeQuery("select * from Libro where autore_id = :autoreId order by prezzo ", Libro.class);
		query.setParameter("autoreId", autoreId);
		return query.getResultList();
	}
	
	public List<Libro> findLibroByGenere(String genere){
		Query query = entityManager.createNativeQuery("select * from Libro where genere = :genere", Libro.class);
		query.setParameter("genere", genere);
		return query.getResultList();
	}
	
	public void save(Libro libro) {
		entityManager.persist(libro);
	}
	
	// trova libri in base al nome e cognome dell'autore
	public List<Libro> findLibriByNomeCognomeAutore(String nome, String cognome){
		Query query = entityManager.createNativeQuery("select libro.* from libro inner join autore on autore.id=libro.autore_id where autore.nome = :nome and autore.cognome = :cognome", Libro.class);
		query.setParameter("nome", nome);
		query.setParameter("cognome", cognome);
		return query.getResultList();
	}
	
	public Libro delete(Libro libro) {
		Libro l = entityManager.find(Libro.class, libro.getId());
		entityManager.remove(l);
		return libro;
	}
	
	public void update(Libro libro) {
		entityManager.merge(libro);
	}
	
}
