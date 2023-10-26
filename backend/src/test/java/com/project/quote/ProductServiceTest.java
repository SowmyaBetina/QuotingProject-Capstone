package com.project.quote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.quote.dto.ProductDTO;
import com.project.quote.entity.Product;
import com.project.quote.repository.ProductRepository;
import com.project.quote.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setName("Product1");
        product1.setInternalName("InternalName1");
        product1.setDetails("Details1");
        product1.setMaxProductsPerLocation(10);

        Product product2 = new Product();
        product2.setName("Product2");
        product2.setInternalName("InternalName2");
        product2.setDetails("Details2");
        product2.setMaxProductsPerLocation(20);

        products.add(product1);
        products.add(product2);

        when(productRepository.findAll()).thenReturn(products);

        List<ProductDTO> productDTOs = productService.getAllProducts();

        assertEquals(2, productDTOs.size());

        ProductDTO productDTO1 = productDTOs.get(0);
        assertEquals("Product1", productDTO1.getName());
        assertEquals("InternalName1", productDTO1.getInternalName());
        assertEquals("Details1", productDTO1.getDetails());
        assertEquals(10, productDTO1.getMaxProductsPerLocation());

        ProductDTO productDTO2 = productDTOs.get(1);
        assertEquals("Product2", productDTO2.getName());
        assertEquals("InternalName2", productDTO2.getInternalName());
        assertEquals("Details2", productDTO2.getDetails());
        assertEquals(20, productDTO2.getMaxProductsPerLocation());
    }

    @Test
    void testGetAllProductNames() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setName("Product1");
        Product product2 = new Product();
        product2.setName("Product2");

        products.add(product1);
        products.add(product2);

        when(productRepository.findAll()).thenReturn(products);

        List<String> productNames = productService.getAllProductNames();

        assertEquals(2, productNames.size());
        assertEquals("Product1", productNames.get(0));
        assertEquals("Product2", productNames.get(1));
    }
}
