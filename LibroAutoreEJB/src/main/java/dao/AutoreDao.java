package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dto.AutoreDTO;
import model.Autore;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class AutoreDao {
	
	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager entityManager;
	
	public Autore findById(int id) {
		return entityManager.find(Autore.class, id);
	}
	
	public List<Autore> findAll(){
		
		TypedQuery<Autore> query = entityManager.createNamedQuery("findAllAutori", Autore.class);
		
		return query.getResultList();
	}
	
	public List<Autore> findByName(String nome){

		Query query = entityManager.createQuery("select a from Autore a where a.nome = :nome", Autore.class);
		query.setParameter("nome", nome);
		
		return query.getResultList();
	}
	
	public void save(Autore autore) {
		entityManager.persist(autore);
	}
	
	public Autore delete(Autore autore) {
		Autore a = entityManager.find(Autore.class, autore.getId());
		entityManager.remove(a);
		return autore;
	}
	
	public List<Autore> findAutoriByNome(String nome){
		Query query = entityManager.createNativeQuery("select * from Autore where nome = :nome", Autore.class);
		query.setParameter("nome", nome);
		
		return query.getResultList();
		
	}
	
	public Autore update(Autore autore) {
		return entityManager.merge(autore);
	}
	
}
