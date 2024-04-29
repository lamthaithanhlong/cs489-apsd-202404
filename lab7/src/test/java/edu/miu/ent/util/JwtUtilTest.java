package edu.miu.ent.util;


import edu.miu.ent.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class JwtUtilTest {

    private JwtUtil jwtUtil;

    @Mock
    private Authentication authentication;

    @BeforeEach
    public void setup() {
        jwtUtil = new JwtUtil();
    }



    @Test
    public void testGenerateToken() {
        
        String email = "bruce@gmial.com";
        when(authentication.getName()).thenReturn(email);
        String token = jwtUtil.generateToken(authentication);
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    public void testExtractUsername() {
        
        String email = "bruce@gmial.com";
        when(authentication.getName()).thenReturn(email);
        String token = jwtUtil.generateToken(authentication);

        
        String extractedEmail = jwtUtil.extractUsername(token);
        assertEquals(email, extractedEmail);
    }

    @Test
    public void testValidateToken() {
        
        String email = "bruce@gmial.com";
        when(authentication.getName()).thenReturn(email);
        String token = jwtUtil.generateToken(authentication);
        User user = new User();
        user.setEmail(email);
        boolean isValid = jwtUtil.validateToken(token, user);
        assertTrue(isValid);
    }

    @Test
    public void testValidateTokenInvalid() {
        
        String email = "bruce@gmial.com";
        when(authentication.getName()).thenReturn(email);
        String token = jwtUtil.generateToken(authentication);
        User user = new User();
        user.setEmail("john@example.com");
        boolean isValid = jwtUtil.validateToken(token, user);
        assertFalse(isValid);
    }
}