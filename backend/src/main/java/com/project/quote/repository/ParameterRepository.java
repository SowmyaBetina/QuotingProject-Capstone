package com.project.quote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quote.entity.Feature;
import com.project.quote.entity.Parameter;

public interface ParameterRepository extends JpaRepository<Parameter, Integer>{
	List<Parameter> findByFeature(Feature feature);
}