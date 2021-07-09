package com.cc2.cc2.configuration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cc2.cc2.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, String> {
	 
}