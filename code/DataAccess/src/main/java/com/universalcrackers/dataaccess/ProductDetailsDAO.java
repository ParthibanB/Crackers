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

import com.universalcrackers.dataaccess.model.ProductDetails;

@Repository
@SuppressWarnings("restriction")
public class ProductDetailsDAO extends GenericDao<ProductDetails> {
	
	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void init(){
		super.setEntityManager(entityManager);
		super.setEntityClass(ProductDetails.class);
	}
	
	@Transactional
    public void create(ProductDetails entity) {
        super.create(entity);
    }

	@Transactional
    public void edit(Long id, ProductDetails entity) {
        super.edit(entity);
    }

	@Transactional
    public void remove(Long id) {
        super.remove(super.find(id));
    }

    public ProductDetails find(Long id) {
        return super.find(id);
    }

    public List<ProductDetails> findAll() {
        return super.findAll();
    }

    public List<ProductDetails> findRange(Integer from,Integer to) {
        return super.findRange(new int[]{from, to});
    }

    public String countREST() {
        return String.valueOf(super.count());
    }
    @SuppressWarnings("unchecked")
    public ProductDetails getPaymentCustomer(String customerId){
    	List<ProductDetails> results =entityManager.createNamedQuery("Paymentcustomer.findByCustomerId")
    				  									  .setParameter("customerId", customerId)
    		                                              .getResultList();
			
			if(null != results && results.size() > 0)
    		  return results.get(0);
			else{
				return null;
			}
		
    }
    
}
