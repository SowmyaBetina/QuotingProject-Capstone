package com.project.quote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.quote.dto.FeatureDTO;
import com.project.quote.entity.Feature;
import com.project.quote.entity.Product;
import com.project.quote.repository.FeatureRepository;
import com.project.quote.repository.ProductRepository;
import com.project.quote.service.FeatureService;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class FeatureServiceTest {

    @InjectMocks
    private FeatureService featureService;

    @Mock
    private FeatureRepository featureRepository;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFeaturesForProductWithValidProduct() {
        Product product = new Product();
        product.setName("Product1");

        when(productRepository.findByName("Product1")).thenReturn(Optional.of(product));

        List<Feature> features = new ArrayList<>();
        Feature feature1 = new Feature();
        feature1.setName("Feature1");
        feature1.setInternalName("InternalName1");
        feature1.setDetails("Details1");

        Feature feature2 = new Feature();
        feature2.setName("Feature2");
        feature2.setInternalName("InternalName2");
        feature2.setDetails("Details2");

        features.add(feature1);
        features.add(feature2);

        when(featureRepository.findByProduct(product)).thenReturn(features);

        List<FeatureDTO> featureDTOs = featureService.getFeaturesForProduct("Product1");

        assertEquals(2, featureDTOs.size());

        FeatureDTO featureDTO1 = featureDTOs.get(0);
        assertEquals("Feature1", featureDTO1.getName());
        assertEquals("InternalName1", featureDTO1.getInternalName());
        assertEquals("Details1", featureDTO1.getDetails());

        FeatureDTO featureDTO2 = featureDTOs.get(1);
        assertEquals("Feature2", featureDTO2.getName());
        assertEquals("InternalName2", featureDTO2.getInternalName());
        assertEquals("Details2", featureDTO2.getDetails());
    }

    @Test
    void testGetFeaturesForProductWithInvalidProduct() {
        when(productRepository.findByName("NonExistentProduct")).thenReturn(Optional.empty());

        List<FeatureDTO> featureDTOs = featureService.getFeaturesForProduct("NonExistentProduct");

        assertEquals(0, featureDTOs.size());
    }
}
