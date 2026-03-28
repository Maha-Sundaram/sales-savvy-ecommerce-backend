package com.salessavvy.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salessavvy.dto.request.ProductRequest;
import com.salessavvy.dto.response.ProductResponse;
import com.salessavvy.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class ProductController {

	private final ProductService productService;
	
	@PostMapping("/admin/products")
	public ProductResponse createProduct(@RequestBody ProductRequest request) {
		
		return productService.createProduct(request);
		
	}
	
	@PostMapping("/admin/products/{id}")
	public ProductResponse updateProduct(@PathVariable long id, @RequestBody ProductRequest request) {
		
		return productService.updateProduct(id, request);
		
	}
	
	@DeleteMapping("/admin/product/{id}")
	public void deleteProduct(@PathVariable Long id) {
		
		productService.deleteProduct(id);
		
	}
	
	@GetMapping("/products")
	public Page<ProductResponse> getProducts(@RequestParam int page, @RequestParam int size) {
		
		return productService.getAllProducts(page, size);
		
	}
	
	
}
