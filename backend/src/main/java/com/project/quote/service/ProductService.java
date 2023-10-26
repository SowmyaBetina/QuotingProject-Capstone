package com.project.quote.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quote.dto.ProductDTO;
import com.project.quote.entity.Product;
import com.project.quote.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;	
	public List<ProductDTO> getAllProducts() {
		 List<Product> products = productRepository.findAll();

        
        return products.stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }
    public List<String> getAllProductNames() {
    	 List<Product> products = productRepository.findAll();
        List<String> productNames = new ArrayList<>();
        
        for (Product product : products) {
            productNames.add(product.getName());
        }
        
        return productNames;
    }

    private ProductDTO mapToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setInternalName(product.getInternalName());
        productDTO.setDetails(product.getDetails());
        productDTO.setMaxProductsPerLocation(product.getMaxProductsPerLocation());
        return productDTO;
    }

}
