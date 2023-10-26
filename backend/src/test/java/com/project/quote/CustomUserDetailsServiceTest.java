package com.project.quote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.quote.service.CustomUserDetailsService;
import com.project.quote.service.UserService;


import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomUserDetailsServiceTest {

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadUserByUsernameWithValidUser() {
        com.project.quote.entity.User userEntity = new com.project.quote.entity.User();
        userEntity.setName("testuser");
        userEntity.setPassword("{bcrypt}$2a$10$abc123");
        userEntity.setRole("USER"); 
    
        when(userService.getByName("testuser")).thenReturn(java.util.Optional.of(userEntity));
    
        UserDetails userDetails = customUserDetailsService.loadUserByUsername("testuser");
    
        assertEquals("testuser", userDetails.getUsername());
        assertEquals("{bcrypt}$2a$10$abc123", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities()
            .stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_USER") || a.getAuthority().equals("USER"))); 
    }
    
    

    @Test
    void testLoadUserByUsernameWithInvalidUser() {
        when(userService.getByName("nonexistentuser")).thenReturn(java.util.Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.loadUserByUsername("nonexistentuser"));
    }
}
