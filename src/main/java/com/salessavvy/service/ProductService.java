package com.salessavvy.service;

import org.springframework.data.domain.Page;

import com.salessavvy.dto.request.ProductRequest;
import com.salessavvy.dto.response.ProductResponse;

public interface ProductService {

	ProductResponse createProduct(ProductRequest request);
	
	ProductResponse updateProduct(Long id, ProductRequest request);
	
	void deleteProduct(Long id);
	
	Page<ProductResponse> getAllProducts(int page, int size);
	
}
