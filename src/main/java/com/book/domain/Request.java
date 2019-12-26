package com.book.domain;

import java.util.List;

public class Request {

	private Long customerId;
	private String customerName;
	private List<Product> productDetailsList;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public List<Product> getProductDetailsList() {
		return productDetailsList;
	}
	
	public void setProductDetailsList(List<Product> productDetailsList) {
		this.productDetailsList = productDetailsList;
	}
	
}
