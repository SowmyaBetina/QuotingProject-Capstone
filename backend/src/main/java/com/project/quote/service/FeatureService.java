package com.project.quote.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quote.dto.FeatureDTO;
import com.project.quote.entity.Feature;
import com.project.quote.entity.Product;
import com.project.quote.repository.FeatureRepository;
import com.project.quote.repository.ProductRepository;

@Service
public class FeatureService {
	
	@Autowired
	private FeatureRepository featureRepository;
	@Autowired
    private ProductRepository productRepository;
	public List<FeatureDTO> getFeaturesForProduct(String productName) {
        Optional<Product> productOptional = productRepository.findByName(productName);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            List<Feature> features = featureRepository.findByProduct(product);
            List<FeatureDTO> featureDTOs = new ArrayList<>();

            for (Feature feature : features) {
                FeatureDTO featureDTO = new FeatureDTO();
                featureDTO.setName(feature.getName());
                featureDTO.setInternalName(feature.getInternalName());
                featureDTO.setDetails(feature.getDetails());
                featureDTOs.add(featureDTO);
            }

            return featureDTOs;
        }

        return Collections.emptyList(); 
    }
    


}
