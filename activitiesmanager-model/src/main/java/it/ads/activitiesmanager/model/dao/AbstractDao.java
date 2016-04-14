package it.ads.activitiesmanager.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//Segnala che si tratta di una classe DAO (o Repository)
@Repository
//Significa che tutti i metodi della classe sono definiti come @Transactional
@Transactional
public abstract class AbstractDao<T extends Serializable> {
	
	private Class<T> c;
	 
	@PersistenceContext
	EntityManager em;

	 
	public final void setClass(Class<T> c){
		this.c = c;
	}
	 
	public T find(Integer id) {
		return em.find(c,id);
	}
	public List<T> findAll(){
		String SELECT = "SELECT * FROM " + c.getName();
		Query query = em.createQuery(SELECT);
		return query.getResultList();
	}
	 
	public void save(T entity){
		em.persist(entity);
	}
	 
	public void update(T entity){
		em.merge(entity);
	}
	 
	public void delete(T entity){
		em.remove(entity);
	}
	public void deleteById(Integer id){
		T entity = find(id);
		delete(entity);
	}
}