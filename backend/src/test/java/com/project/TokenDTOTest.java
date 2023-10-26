package com.project;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.quote.business.TokenDTO;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

class TokenDTOTest {

    private TokenDTO tokenDTO;

    @BeforeEach
    void setUp() {
        tokenDTO = new TokenDTO();
    }

    @Test
    void testGetToken() {
        assertNull(tokenDTO.getToken());
        tokenDTO.setToken("testToken");
        assertEquals("testToken", tokenDTO.getToken());
    }

    @Test
    void testSetToken() {
        assertNull(tokenDTO.getToken());
        tokenDTO.setToken("testToken");
        assertEquals("testToken", tokenDTO.getToken());
    }

    @Test
    void testSetTokenWithNull() {
        assertNull(tokenDTO.getToken());
        tokenDTO.setToken(null);
        assertNull(tokenDTO.getToken());
    }

    @Test
    void testSetTokenEmpty() {
        assertNull(tokenDTO.getToken());
        tokenDTO.setToken("");
        assertEquals("", tokenDTO.getToken());
    }
    @Test
    void testGeneratedMethods() {
        
      
        assertNotNull(tokenDTO.toString());
     
        
        tokenDTO.setToken("testToken");
        assertEquals("testToken", tokenDTO.getToken());
    }

  

    @Test
    void testPrivateFieldToken() {
        
        try {
            Field tokenField = tokenDTO.getClass().getDeclaredField("token");
            tokenField.setAccessible(true);
            tokenField.set(tokenDTO, "testToken");

            assertEquals("testToken", tokenField.get(tokenDTO));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to access and test the 'token' field.");
        }
    }

}
