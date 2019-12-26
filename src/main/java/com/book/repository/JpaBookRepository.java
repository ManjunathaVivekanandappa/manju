package com.book.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.book.domain.Customer;
import com.book.domain.Product;


@Repository
public class JpaBookRepository implements BookRepository {

    @PersistenceContext
    private EntityManager em;
	
    @Override
    @Transactional
    public Customer addToCart(Customer customer) {
    //	customer.setCustomerId(getNextCustomerId());
		em.persist(customer);
		return customer;
		
	}


	@Override
	public Customer getCustomerDetails(Long customerId) {
		Customer customer=new Customer();
		Query qry = em.createQuery("Select c from Customer c where c.customerId=:customerId ");
		qry.setParameter("customerId", customerId);
		customer=(Customer)qry.getSingleResult();
		return customer;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductDetails(Long customerId) {
		List<Product> productList=null;
		Query qry = em.createQuery("Select p from Product p where p.customerId=:customerId ");
		qry.setParameter("customerId", customerId);
		productList=qry.getResultList();
	return productList;
	}


	@Override
	public Product addProductDetails(Product product) {
		em.persist(product);
		return product;
		
	}
	
	public Long getNextCustomerId() {

		Query qry = em.createNativeQuery("select customer_id.nextval from dual");
		BigDecimal issueID = (BigDecimal) qry.getSingleResult();
		return Long.valueOf(issueID.longValue());
	}


}
