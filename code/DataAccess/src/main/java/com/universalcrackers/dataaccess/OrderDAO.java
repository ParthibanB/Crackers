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

import com.universalcrackers.dataaccess.model.Order;

@Repository
@SuppressWarnings("restriction")
public class OrderDAO extends GenericDao<Order> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void init(){
		super.setEntityManager(entityManager);
		super.setEntityClass(Order.class);
	}
	
	@Transactional
    public void create(Order entity) {
        super.create(entity);
    }

	@Transactional
    public void edit(Long id, Order entity) {
        super.edit(entity);
    }

	@Transactional
    public void remove(Long id) {
        super.remove(super.find(id));
    }

    public Order find(Long id) {
        return super.find(id);
    }

    public List<Order> findAll() {
        return super.findAll();
    }

    public List<Order> findRange(Integer from,Integer to) {
        return super.findRange(new int[]{from, to});
    }

    public String countREST() {
        return String.valueOf(super.count());
    }

}
