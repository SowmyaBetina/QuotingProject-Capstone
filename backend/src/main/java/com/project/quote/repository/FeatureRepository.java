package com.project.quote.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quote.entity.Feature;
import com.project.quote.entity.Product;
public interface FeatureRepository extends JpaRepository<Feature, Integer> {
	
	List<Feature> findByProduct(Product product);
	Optional<Feature> findByName(String name);
}