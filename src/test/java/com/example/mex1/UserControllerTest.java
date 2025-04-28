package com.example.mex1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {


//    private UserRepository mockRepo;
//    private UserService userService;
//    private UserController userController;
//
//    @BeforeEach
//    void setUp() {
//        // Körs före varje testmetod
//        mockRepo = mock(UserRepository.class); // Mocka UserRepository
//        userService = new UserService(mockRepo); // Skapa UserService med mockad repo
//        userController = new UserController(userService); // Skapa UserController
//    }
//
//    @AfterEach
//    void tearDown() {
//        // Körs efter varje testmetod
//        mockRepo = null; // Städa upp referensen
//        userService = null; // Städa upp referensen
//        userController = null; // Städa upp referensen
//    }
    @Test
    void registerUserShouldReturnSuccessMessage() {
        UserRepository mockRepo = mock(UserRepository.class);
        UserService userService = new UserService(mockRepo);
        UserController userController = new UserController(userService);

        User user = new User("alice", "alice@example.com");
        when(mockRepo.existsByUsername("alice")).thenReturn(false);

        String response = userController.registerUser(user);

        assertEquals("User registered successfully", response);
        verify(mockRepo).save(user);
    }

    @Test
    void getUserShouldReturnUser() {
        UserRepository mockRepo = mock(UserRepository.class);
        UserService userService = new UserService(mockRepo);
        UserController userController = new UserController(userService);

        User user = new User("bob", "bob@example.com");
        when(mockRepo.findByUsername("bob")).thenReturn(user);

        User result = userController.getUser("bob");

        assertEquals("bob", result.getUsername());
        assertEquals("bob@example.com", result.getEmail());
    }
}
