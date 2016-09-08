/**
 * 
 */
package com.universalcrackers.dataaccess;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.universalcrackers.dataaccess.model.Product;

@Repository
@SuppressWarnings("restriction")
public class ProductDAO extends GenericDao<Product> {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void init(){
		super.setEntityManager(entityManager);
		super.setEntityClass(Product.class);
	}

	@Transactional
	public void create(Product entity) {
		super.create(entity);
	}
	
	@Transactional
	public void edit(Long id, Product entity) {
		super.edit(entity);
	}

	@Transactional
	public void remove(Long id) {
		super.remove(super.find(id));
	}

	public Product find(Long id) {
		return super.find(id);
	}

	public List<Product> findAll() {
		return super.findAll();
	}

	public List<Product> findRange(Integer from,Integer to) {
		return super.findRange(new int[]{from, to});
	}

	public String countREST() {
		return String.valueOf(super.count());
	}
}
