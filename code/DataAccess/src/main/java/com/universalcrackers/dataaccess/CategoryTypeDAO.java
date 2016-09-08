package com.universalcrackers.dataaccess;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.universalcrackers.dataaccess.model.CategoryType;

@Repository
@SuppressWarnings("restriction")
public class CategoryTypeDAO extends GenericDao<CategoryType> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void init(){
		super.setEntityManager(entityManager);
		super.setEntityClass(CategoryType.class);
	}
	
	@Transactional
    public void create(CategoryType entity) {
        super.create(entity);
    }

	@Transactional
    public void edit(Long id, CategoryType entity) {
        super.edit(entity);
    }

	@Transactional
    public void remove(Long id) {
        super.remove(super.find(id));
    }

   
    public CategoryType find(Long id) {
        return super.find(id);
    }

    
    public List<CategoryType> findAll() {
        return super.findAll();
    }

    
    public List<CategoryType> findRange(Integer from,Integer to) {
        return super.findRange(new int[]{from, to});
    }

    
    public String countREST() {
        return String.valueOf(super.count());
    }
}
