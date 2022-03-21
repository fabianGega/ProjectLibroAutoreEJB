package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.transform.Transformers;

import dto.JoinLibroAutoreTo;

@Stateless
public class ResponseJoinDao {
	
	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager entityManager;
	
	public List<JoinLibroAutoreTo> findByJoin(){
		List<JoinLibroAutoreTo> dtoList = entityManager.createNativeQuery("select nome, cognome, titolo, genere from autore inner join libro on autore.id=libro.autore_id")
				.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.aliasToBean(JoinLibroAutoreTo.class)).list();
		
		return dtoList;
	}

}
