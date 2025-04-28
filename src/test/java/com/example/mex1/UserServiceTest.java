package com.example.mex1;

import static org.junit.jupiter.api.Assertions.*;

// src/test/java/com/example/demo/UserServiceTest.java


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void registerUserShouldCallSaveWhenUserIsNew() {
        UserRepository mockRepo = mock(UserRepository.class);
        UserService service = new UserService(mockRepo);
        User user = new User("alice", "alice@example.com");

        when(mockRepo.existsByUsername("alice")).thenReturn(false);

        service.registerUser(user);

        verify(mockRepo).save(user);
    }

    @Test
    void registerUserShouldThrowIfUserExists() {
        UserRepository mockRepo = mock(UserRepository.class);
        UserService service = new UserService(mockRepo);
        User user = new User("bob", "bob@example.com");

        when(mockRepo.existsByUsername("bob")).thenReturn(true);

        assertThrows(IllegalStateException.class, () -> service.registerUser(user));
        verify(mockRepo, never()).save(any());
    }
}
