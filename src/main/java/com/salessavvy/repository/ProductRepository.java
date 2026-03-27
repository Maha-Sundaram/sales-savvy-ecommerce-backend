package com.salessavvy.repository;

import java.awt.print.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salessavvy.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Pageable findAll(Pageable pageable);

}
