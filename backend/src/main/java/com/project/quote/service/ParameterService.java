package com.project.quote.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quote.dto.ParameterDTO;
import com.project.quote.entity.Feature;
import com.project.quote.entity.Parameter;
import com.project.quote.repository.FeatureRepository;
import com.project.quote.repository.ParameterRepository;

@Service
public class ParameterService {
	@Autowired
	private ParameterRepository parameterRepository;
	@Autowired
    private FeatureRepository featureRepository;
	
	
	public List<ParameterDTO> getParametersForFeature(String featureName) {
        Optional<Feature> featureOptional = featureRepository.findByName(featureName);

        if (featureOptional.isPresent()) {
            Feature feature = featureOptional.get();
            List<Parameter> parameters = parameterRepository.findByFeature(feature);
            List<ParameterDTO> parameterDTOs = new ArrayList<>();

            for (Parameter parameter : parameters) {
                ParameterDTO parameterDTO = new ParameterDTO();
                parameterDTO.setName(parameter.getName());
                parameterDTO.setDetails(parameter.getDetails());
                parameterDTO.setPrice(parameter.getPrice());
                parameterDTO.setQuantity(parameter.getQuantity());
                parameterDTOs.add(parameterDTO);
            }

            return parameterDTOs;
        }

        return Collections.emptyList(); 
    }
    
    
    
	
}

