package com.book.service;

import com.book.domain.Request;
import com.book.domain.Response;

public interface BookStoreService {

	public Response addToCartDetails(Request request);
	public Response billReceipt(Long customerId);
}
