package com.salessavvy.serviceImpl;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.salessavvy.dto.request.ProductRequest;
import com.salessavvy.dto.response.ProductResponse;
import com.salessavvy.entity.Product;
import com.salessavvy.repository.ProductRepository;
import com.salessavvy.service.ProductService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	@Override
	public ProductResponse createProduct(ProductRequest request) {
		Product product = new Product();
		
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
		product.setStock(request.getStock());
		
		Product saved = productRepository.save(product);
		
		return new ProductResponse(saved.getId(), saved.getName(), saved.getDescription(), saved.getPrice(),saved.getCreatedAt());
	}

	@Override
	public ProductResponse updateProduct(Long id, ProductRequest request) {
		
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
		product.setStock(request.getStock());
		
		Product updated = productRepository.save(product);
		
		return new ProductResponse(updated.getId(), updated.getName(), updated.getDescription(), updated.getPrice(), updated.getUpdatedAt());
		
	}

	@Override
	public void deleteProduct(Long id) {
		
		productRepository.deleteById(id);
	}

	@Override
	public Page<ProductResponse> getAllProducts(int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		return productRepository.findAll(pageable)
				.map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCreatedAt()));
	}

}
