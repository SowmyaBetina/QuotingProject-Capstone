package com.project.quote.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quote.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	 Optional<Product> findByName(String name);
}