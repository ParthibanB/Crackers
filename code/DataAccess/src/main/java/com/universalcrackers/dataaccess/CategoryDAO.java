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

import com.universalcrackers.dataaccess.model.Category;

@Repository
@SuppressWarnings("restriction")
public class CategoryDAO extends GenericDao<Category> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void init(){
		super.setEntityManager(entityManager);
		super.setEntityClass(Category.class);
	}
	
	@Transactional
    public void create(Category entity) {
        super.create(entity);
    }

	@Transactional
    public void edit(Long id, Category entity) {
        super.edit(entity);
    }

	@Transactional
    public void remove(Long id) {
        super.remove(super.find(id));
    }

    public Category find(Long id) {
        return super.find(id);
    }

    public List<Category> findAll() {
        return super.findAll();
    }

    public List<Category> findRange(Integer from,Integer to) {
        return super.findRange(new int[]{from, to});
    }

    public String countREST() {
        return String.valueOf(super.count());
    }
}
