package com.book.domain;

import java.util.List;

public class Response {

	private Customer customerDetails;
	private List<Product> productList;
	private Long salesTax;
	private Long vatTax;
	private Double discount;
	private Long total;
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Long getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(Long salesTax) {
		this.salesTax = salesTax;
	}
	public Long getVatTax() {
		return vatTax;
	}
	public void setVatTax(Long vatTax) {
		this.vatTax = vatTax;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long l) {
		this.total = l;
	}
	public Customer getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}
	
}
