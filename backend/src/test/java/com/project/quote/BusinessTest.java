package com.project.quote;



import com.project.quote.business.LoginBody;
import com.project.quote.business.TokenDTO;
import com.project.quote.business.UserForm;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

class BusinessTest {

    @Test
    public void testLoginBody() {
        LoginBody loginBody = new LoginBody();
        loginBody.setUsername("testuser");
        loginBody.setPassword("password");

        assertEquals("testuser", loginBody.getUsername());
        assertEquals("password", loginBody.getPassword());
    }

    @Test
    public void testTokenDTO() {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken("token123");

        assertEquals("token123", tokenDTO.getToken());
    }

    @Test
    public void testUserForm() {
        UserForm userForm = new UserForm();
        userForm.setName("John");
        userForm.setPassword("password");
        userForm.setPasswordRepeat("password");

        assertEquals("John", userForm.getName());
        assertEquals("password", userForm.getPassword());
        assertEquals("password", userForm.getPasswordRepeat());
    }
}
