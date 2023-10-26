package com.project.quote;


import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.quote.business.LoginBody;
import com.project.quote.entity.User;
import com.project.quote.service.UserService;

import java.util.Collections;

import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestInstance;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.context.SecurityContext;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

 

@SpringBootTest

@AutoConfigureMockMvc

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class ApiAuthControllerTests {

 

  @Autowired

  private MockMvc mockMvc;

 

  @MockBean

  private UserService userService;

 

  private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

 

  @MockBean

  private AuthenticationManager authenticationManager;

 

  @Autowired

  private ObjectMapper objectMapper;

 

  private User user;

 

  @BeforeAll

  public void setUp() {

    user = new User();

    user.setName("test");

    user.setPassword("{bcrypt}" + passwordEncoder.encode("test123"));

  

  }


  @Test

  void testUserAuthentication() throws Exception {

    LoginBody loginBody = new LoginBody();

    loginBody.setUsername("test");

    loginBody.setPassword("test123");

 

    when(userService.getByName("test")).thenReturn(Optional.of(user));

 

    List<GrantedAuthority> authorities = Collections.singletonList(

      new SimpleGrantedAuthority("ROLE_USER")

    );

    Authentication auth = new UsernamePasswordAuthenticationToken(

      "test",

      "test123",

      authorities

    );

 

    when(

      authenticationManager.authenticate(

        new UsernamePasswordAuthenticationToken("test", "test123")

      )

    )

      .thenReturn(auth);

    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

    securityContext.setAuthentication(auth);

    SecurityContextHolder.setContext(securityContext);

 

    mockMvc

      .perform(

        MockMvcRequestBuilders

          .post("/api/auth/token")

          .contentType(MediaType.APPLICATION_JSON)

          .content(objectMapper.writeValueAsString(loginBody))

      )

      .andExpect(status().isOk())

      .andExpect(content().contentType(MediaType.APPLICATION_JSON))

      .andExpect(jsonPath("$.token").isNotEmpty());

  }

}

 
