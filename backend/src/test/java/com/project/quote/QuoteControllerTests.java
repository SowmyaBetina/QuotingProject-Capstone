package com.project.quote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.quote.controller.QuoteController;
import com.project.quote.dto.FeatureDTO;
import com.project.quote.dto.ParameterDTO;
import com.project.quote.dto.ProductDTO;
import com.project.quote.dto.QuoteCustomerDTO;
import com.project.quote.entity.Customer;

import com.project.quote.entity.Location;
import com.project.quote.entity.Price;
import com.project.quote.entity.Product;
import com.project.quote.entity.Quote;
import com.project.quote.entity.User;
import com.project.quote.repository.CustomerRepository;
import com.project.quote.repository.FeatureRepository;
import com.project.quote.repository.LocationRepository;
import com.project.quote.repository.PriceRepository;
import com.project.quote.repository.ProductRepository;
import com.project.quote.repository.QuoteRepository;
import com.project.quote.repository.UserRepository;
import com.project.quote.service.FeatureService;
import com.project.quote.service.ParameterService;
import com.project.quote.service.ProductService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class QuoteControllerTests {

    @InjectMocks
    private QuoteController quoteController;

    @Mock
    private QuoteRepository quoteRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private FeatureRepository featureRepository;

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductService productService;

    @Mock
    private FeatureService featureService;

    @Mock
    private ParameterService parameterService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUserWithValidUser() {
        User user = new User();
        user.setName("testuser");
        user.setPassword("password123");

        when(userRepository.existsByName("testuser")).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);

        ResponseEntity<String> response = quoteController.registerUser(user);

        assertEquals("User registered successfully", response.getBody());
    }

    @Test
    void testRegisterUserWithExistingUser() {
        User user = new User();
        user.setName("testuser");
        user.setPassword("password123");

        when(userRepository.existsByName("testuser")).thenReturn(true);

        ResponseEntity<String> response = quoteController.registerUser(user);

        assertEquals("Username already exists", response.getBody());
    }

    @Test
    void testGetProductNames() {
        List<String> productNames = new ArrayList<>();
        productNames.add("Product A");
        productNames.add("Product B");
        productNames.add("Product C");

        when(productService.getAllProductNames()).thenReturn(productNames);

        List<String> result = quoteController.getProductNames();

        assertEquals(productNames, result);
    }

    @Test
    void testGetSelectedData() {
        Customer customer = new Customer();
        customer.setCustomerName("Test Customer");
        customer.setAccountStatus("Active");

        List<Quote> quotes = new ArrayList<>();
        Quote quote1 = new Quote();
        quote1.setQuoteName("Quote 1");
        quote1.setQuoteOwner("User A");
        Quote quote2 = new Quote();
        quote2.setQuoteName("Quote 2");
        quote2.setQuoteOwner("User B");
        quotes.add(quote1);
        quotes.add(quote2);

        when(customerRepository.findAll()).thenReturn(Collections.singletonList(customer));
        when(quoteRepository.findAll()).thenReturn(quotes);

        List<QuoteCustomerDTO> result = quoteController.getSelectedData();

        assertEquals(2, result.size());
        assertEquals("Test Customer", result.get(0).getCustomerName());
        assertEquals("Active", result.get(0).getAccountStatus());
        assertEquals("Quote 1", result.get(0).getQuoteName());
        assertEquals("User A", result.get(0).getQuoteOwner());
        assertEquals("Quote 2", result.get(1).getQuoteName());
        assertEquals("User B", result.get(1).getQuoteOwner());
    }

    @Test
    void testGetAllLocations() {
        List<Location> locations = new ArrayList<>();
        Location location1 = new Location();
        location1.setLocation("Location A");
        Location location2 = new Location();
        location2.setLocation("Location B");
        locations.add(location1);
        locations.add(location2);

        when(locationRepository.findAll()).thenReturn(locations);

        List<Location> result = quoteController.getAllLocations();

        assertEquals(locations, result);
    }

    @Test
    void testCreateLocation() {
        Location location = new Location();
        location.setLocation("New Location");

        when(locationRepository.save(location)).thenReturn(location);

        Location result = quoteController.createLocation(location);

        assertEquals("New Location", result.getLocation());
    }

    @Test
    void testGetAllProducts() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setName("Product A");
        productDTO1.setInternalName("Internal A");
        productDTO1.setDetails("Details A");
        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setName("Product B");
        productDTO2.setInternalName("Internal B");
        productDTO2.setDetails("Details B");
        productDTOs.add(productDTO1);
        productDTOs.add(productDTO2);

        when(productService.getAllProducts()).thenReturn(productDTOs);

        List<ProductDTO> result = quoteController.getAllProducts();

        assertEquals(productDTOs, result);
    }
    @Test
    void testGetFeaturesForProduct() {
        String productName = "Product A";
        List<FeatureDTO> featureDTOs = new ArrayList<>();
        FeatureDTO featureDTO1 = new FeatureDTO();
        featureDTO1.setName("Feature 1");
        featureDTO1.setInternalName("Internal 1");
        featureDTO1.setDetails("Details 1");
        FeatureDTO featureDTO2 = new FeatureDTO();
        featureDTO2.setName("Feature 2");
        featureDTO2.setInternalName("Internal 2");
        featureDTO2.setDetails("Details 2");
        featureDTOs.add(featureDTO1);
        featureDTOs.add(featureDTO2);

        when(featureService.getFeaturesForProduct(productName)).thenReturn(featureDTOs);

        List<FeatureDTO> result = quoteController.getFeaturesForProduct(productName);

        assertEquals(featureDTOs, result);
    }

    @Test
    void testGetParametersForFeature() {
        String featureName = "Feature A";
        List<ParameterDTO> parameterDTOs = new ArrayList<>();
        ParameterDTO parameterDTO1 = new ParameterDTO();
        parameterDTO1.setName("Parameter 1");
        parameterDTO1.setDetails("Details 1");
        parameterDTO1.setPrice("10");
        parameterDTO1.setQuantity("5");
        ParameterDTO parameterDTO2 = new ParameterDTO();
        parameterDTO2.setName("Parameter 2");
        parameterDTO2.setDetails("Details 2");
        parameterDTO2.setPrice("15");
        parameterDTO2.setQuantity("8");
        parameterDTOs.add(parameterDTO1);
        parameterDTOs.add(parameterDTO2);

        when(parameterService.getParametersForFeature(featureName)).thenReturn(parameterDTOs);

        List<ParameterDTO> result = quoteController.getParametersForFeature(featureName);

        assertEquals(parameterDTOs, result);
    }

    @Test
    void testGetFeaturesForProductWithInvalidProduct() {
        int productId = 1;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        List<FeatureDTO> result = quoteController.getFeaturesForProduct(productId);

        assertTrue(result.isEmpty());
    }

    @Test
    void testCalculatePriceWithValidProduct() {
        String productName = "Product A";
        int quantity = 5;
        Product product = new Product();
        product.setId(1);
        Price price = new Price();
        price.setPrice(10.0);

        when(productRepository.findByName(productName)).thenReturn(Optional.of(product));
        when(priceRepository.findByProductId(product.getId())).thenReturn(Optional.of(price));

        ResponseEntity<Double> response = quoteController.calculatePrice(productName, quantity);

        assertEquals(50.0, response.getBody());
    }

    @Test
    void testCalculatePriceWithInvalidProduct() {
        String productName = "Product X";

        when(productRepository.findByName(productName)).thenReturn(Optional.empty());

        ResponseEntity<Double> response = quoteController.calculatePrice(productName, 10);

        assertEquals(0.0, response.getBody());
    }


}

