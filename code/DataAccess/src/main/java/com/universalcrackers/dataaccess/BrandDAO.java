package com.universalcrackers.dataaccess;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.universalcrackers.dataaccess.model.Brand;

@Repository
@SuppressWarnings("restriction")
public class BrandDAO extends GenericDao<Brand> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void init(){
		super.setEntityManager(entityManager);
		super.setEntityClass(Brand.class);
	}
	
	@Transactional
	public void create(Brand entity) {
		super.create(entity);
	}

	@Transactional
	public void edit(Long id, Brand entity) {
		super.edit(entity);
	}

	@Transactional
	public void remove(Long id) {
		super.remove(super.find(id));
	}


	public Brand find(Long id) {
		return super.find(id);
	}


	public List<Brand> findAll() {
		return super.findAll();
	}


	public List<Brand> findRange(Integer from,Integer to) {
		return super.findRange(new int[]{from, to});
	}

	public String countREST() {
		return String.valueOf(super.count());
	}
}
