package com.universalcrackers.dataaccess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDao <T> {

	private Class<T> entityClass;
	
	protected EntityManager entityManager;
	
	@Transactional
	public void create(T entity) {
		entityManager.persist(entity);
	}
	
	@Transactional
	public T save(T entity) {
		T t = entityManager.merge(entity);
		return t;
	}

	@Transactional
	public void edit(T entity) {
		entityManager.merge(entity);
	}

	@Transactional
	public void remove(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	public T find(Object id) {
		return entityManager.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		CriteriaQuery<Object> cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return (List<T>) entityManager.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findRange(int[] range) {
		CriteriaQuery<Object> cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = entityManager.createQuery(cq);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	public int count() {
		CriteriaQuery<Object> cq = entityManager.getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(entityManager.getCriteriaBuilder().count(rt));
		javax.persistence.Query q = entityManager.createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String query, HashMap<String, Object> params) {
		List<T> list = null;
		Query namedQuery = entityManager.createNamedQuery(query);
		if(params != null){
			for(Map.Entry<String,Object> param : params.entrySet()){
				namedQuery.setParameter(param.getKey(), param.getValue());
			}
		}
		entityManager.clear();
		entityManager.getEntityManagerFactory().getCache().evictAll();
		list = (List<T>)namedQuery.setHint("org.hibernate.cacheMode", "IGNORE").getResultList();
		return list;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
