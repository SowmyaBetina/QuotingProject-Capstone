package com.project.quote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.quote.entity.User;
import com.project.quote.repository.UserRepository;
import com.project.quote.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);

        // Configure SecurityContextHolder to return a mock authentication
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        SecurityContextHolder.setContext(securityContext);
        Authentication authentication = Mockito.mock(Authentication.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
    }

 
    

    @Test
    void testAuthenticateWithInvalidPassword() {
        User user = new User();
        user.setName("testuser");
        user.setPassword("{bcrypt}$2a$10$abc123");

        when(userRepository.findByName("testuser")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongpassword", "{bcrypt}$2a$10$abc123")).thenReturn(false);

        Optional<User> authenticatedUser = userService.authenticate("testuser", "wrongpassword");
        assertTrue(authenticatedUser.isEmpty());
    }

    @Test
    void testCreateUser() {
        User newUser = new User();
        newUser.setName("newuser");
        newUser.setPassword("password123");

        when(userRepository.save(newUser)).thenReturn(newUser);

        User createdUser = userService.create(newUser);

        assertEquals("newuser", createdUser.getName());
        assertTrue(createdUser.getPassword().startsWith("{bcrypt}"));
    }

    @Test
    void testGetById() {
        User user = new User();
        user.setId(1);

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Optional<User> retrievedUser = userService.getById(1);

        assertTrue(retrievedUser.isPresent());
        assertEquals(1, retrievedUser.get().getId());
    }

    @Test
    void testGetByName() {
        User user = new User();
        user.setName("testuser");

        when(userRepository.findByName("testuser")).thenReturn(Optional.of(user));

        Optional<User> retrievedUser = userService.getByName("testuser");

        assertTrue(retrievedUser.isPresent());
        assertEquals("testuser", retrievedUser.get().getName());
    }

    @Test
    void testGetLoggedInUser() {
        User user = new User();
        user.setName("loggedinuser");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        when(authentication.getName()).thenReturn("loggedinuser");
        when(userRepository.findByName("loggedinuser")).thenReturn(Optional.of(user));

        User loggedInUser = userService.getLoggedInUser();

        assertNotNull(loggedInUser);
        assertEquals("loggedinuser", loggedInUser.getName());
    }
}
