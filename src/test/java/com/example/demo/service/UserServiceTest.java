package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.demo.User;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    private User testUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User();
        testUser.setUsername("testuser");
        testUser.setEmail("testuser@example.com");
        testUser.setPassword("password123");
        testUser.setConfirmPassword("password123");
    }

    @Test
    public void testAuthenticate_Success() {
        // Arrange
        String hashedPassword = new BCryptPasswordEncoder().encode("password123");
        testUser.setPassword(hashedPassword);
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));
        // Act
        boolean isAuthenticated = userService.authenticate("testuser", "password123");
        // Assert
        assertTrue(isAuthenticated);
    }

    @Test
    public void testAuthenticate_Failure() {
        // Arrange
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.empty());
        //Act
         boolean isAuthenticated = userService.authenticate("testuser", "password123");
        // Assert
         assertFalse(isAuthenticated);
        }
    @Test public void testAuthenticate_IncorrectPassword () {// Arrange
        String hashedPassword = new BCryptPasswordEncoder().encode("password123");
        testUser.setPassword(hashedPassword);
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));
        // Act
        boolean isAuthenticated = userService.authenticate("testuser", "wrongpassword");
        // Assert
        assertFalse(isAuthenticated);
    }
}











