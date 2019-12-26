package com.book.repository;

import java.util.List;

import com.book.domain.Customer;
import com.book.domain.Product;

public interface BookRepository {

	public Customer addToCart(Customer customer);
	public Customer getCustomerDetails(Long customerId);
	public List<Product> getProductDetails(Long customerId);
	public Product addProductDetails(Product product);
}
