package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.domain.Customer;
import com.book.domain.Product;
import com.book.domain.Request;
import com.book.domain.Response;
import com.book.repository.BookRepository;

@Service
public class BookStoreServiceImpl implements BookStoreService {

	@Autowired
	BookRepository bookRepo;

	@Override
	public Response addToCartDetails(Request request) {

		Response response = new Response();
		Product product = new Product();
		Customer customer = new Customer();
		customer.setCustomerId(request.getCustomerId());
		customer.setCustomerName(request.getCustomerName());

		List<Product> productList = request.getProductDetailsList();

		customer = bookRepo.addToCart(customer);
		if (productList != null && productList.size() > 0) {
			product.setCustomerId(customer.getCustomerId());
			for (Product prod : productList) {
				product.setProductId(prod.getProductId());
				product.setProductName(prod.getProductName());
				product.setPrice(prod.getPrice());
				product = bookRepo.addProductDetails(product);

			}
		}
		response.setCustomerDetails(customer);
		response.setProductList(productList);
		return response;
	}

	@Override
	public Response billReceipt(Long customerId) {

		Double total = 0.0;
		Response response = new Response();
		Customer customer = bookRepo.getCustomerDetails(customerId);
		response.setCustomerDetails(customer);
		List<Product> productList = bookRepo.getProductDetails(customerId);
		if (productList != null && productList.size() > 0) {
			response.setProductList(productList);
			for (Product prod : productList) {
				total += prod.getPrice();
			}
			Double salesTax = total * (7 / 100);
			Double vatTax = total * (4 / 100);
			response.setSalesTax(salesTax.longValue());
			response.setVatTax(vatTax.longValue());
			total = salesTax + vatTax;
			Double discount = null;
			if (total >= 500 && total <= 1000) {
				total -= (total * (5 / 100));
			} else if (total >= 1000 && total <= 1500) {
				discount = total - (total * (10 / 100));
			} else if (total >= 1500 && total <= 2000) {
				discount = total - (total * (15 / 100));
			} else if (total >= 2000) {
				discount = total - (total * (20 / 100));
			}
			response.setDiscount(discount.doubleValue());
			response.setTotal(Math.round(total));
			return response;
		} else {
			return null;
		}

	}

}
