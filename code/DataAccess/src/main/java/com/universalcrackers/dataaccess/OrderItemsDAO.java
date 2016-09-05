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

import com.universalcrackers.model.OrderItems;


@Repository
@SuppressWarnings("restriction")
public class OrderItemsDAO extends GenericDao<OrderItems> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void init(){
		super.setEntityManager(entityManager);
		super.setEntityClass(OrderItems.class);
	}
	
	@Transactional
	public void create(OrderItems entity) {
		super.create(entity);
	}

	@Transactional
	public void edit(Long id, OrderItems entity) {
		super.edit(entity);
	}

	@Transactional
	public void remove(Long id) {
		super.remove(super.find(id));
	}


	public OrderItems find(Long id) {
		return super.find(id);
	}


	public List<OrderItems> findAll() {
		return super.findAll();
	}


	public List<OrderItems> findRange(Integer from,Integer to) {
		return super.findRange(new int[]{from, to});
	}


	public String countREST() {
		return String.valueOf(super.count());
	}

}
