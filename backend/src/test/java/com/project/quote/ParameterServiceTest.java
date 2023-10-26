package com.project.quote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.quote.dto.ParameterDTO;
import com.project.quote.entity.Feature;
import com.project.quote.entity.Parameter;
import com.project.quote.repository.FeatureRepository;
import com.project.quote.repository.ParameterRepository;
import com.project.quote.service.ParameterService;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ParameterServiceTest {

    @InjectMocks
    private ParameterService parameterService;

    @Mock
    private ParameterRepository parameterRepository;

    @Mock
    private FeatureRepository featureRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetParametersForFeatureWithValidFeature() {
        Feature feature = new Feature();
        feature.setName("Feature1");

        when(featureRepository.findByName("Feature1")).thenReturn(Optional.of(feature));

        List<Parameter> parameters = new ArrayList<>();
        Parameter parameter1 = new Parameter();
        parameter1.setName("Parameter1");
        parameter1.setDetails("Details1");
        parameter1.setPrice("Price1");
        parameter1.setQuantity("Quantity1");

        Parameter parameter2 = new Parameter();
        parameter2.setName("Parameter2");
        parameter2.setDetails("Details2");
        parameter2.setPrice("Price2");
        parameter2.setQuantity("Quantity2");

        parameters.add(parameter1);
        parameters.add(parameter2);

        when(parameterRepository.findByFeature(feature)).thenReturn(parameters);

        List<ParameterDTO> parameterDTOs = parameterService.getParametersForFeature("Feature1");

        assertEquals(2, parameterDTOs.size());

        ParameterDTO parameterDTO1 = parameterDTOs.get(0);
        assertEquals("Parameter1", parameterDTO1.getName());
        assertEquals("Details1", parameterDTO1.getDetails());
        assertEquals("Price1", parameterDTO1.getPrice());
        assertEquals("Quantity1", parameterDTO1.getQuantity());

        ParameterDTO parameterDTO2 = parameterDTOs.get(1);
        assertEquals("Parameter2", parameterDTO2.getName());
        assertEquals("Details2", parameterDTO2.getDetails());
        assertEquals("Price2", parameterDTO2.getPrice());
        assertEquals("Quantity2", parameterDTO2.getQuantity());
    }

    @Test
    void testGetParametersForFeatureWithInvalidFeature() {
        when(featureRepository.findByName("NonExistentFeature")).thenReturn(Optional.empty());

        List<ParameterDTO> parameterDTOs = parameterService.getParametersForFeature("NonExistentFeature");

        assertEquals(0, parameterDTOs.size());
    }
}
