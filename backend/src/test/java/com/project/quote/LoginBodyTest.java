package com.project.quote;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.quote.business.LoginBody;

import static org.junit.jupiter.api.Assertions.*;

class LoginBodyTest {

    private LoginBody loginBody;

    @BeforeEach
    void setUp() {
        loginBody = new LoginBody();
    }

    @Test
    void testGetUsername() {
        assertNull(loginBody.getUsername());
        loginBody.setUsername("testUser");
        assertEquals("testUser", loginBody.getUsername());
    }

    @Test
    void testGetPassword() {
        assertNull(loginBody.getPassword());
        loginBody.setPassword("testPassword");
        assertEquals("testPassword", loginBody.getPassword());
    }

    @Test
    void testSetUsername() {
        assertNull(loginBody.getUsername());
        loginBody.setUsername("testUser");
        assertEquals("testUser", loginBody.getUsername());
    }

    @Test
    void testSetPassword() {
        assertNull(loginBody.getPassword());
        loginBody.setPassword("testPassword");
        assertEquals("testPassword", loginBody.getPassword());
    }
}
