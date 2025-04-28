package com.example.mex1;

// src/main/java/com/example/demo/UserService.java

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public void registerUser(User user) {
        if (repo.existsByUsername(user.getUsername())) {
            throw new IllegalStateException("Username already taken");
        }
        repo.save(user);
    }

    public User getUser(String username) {
        return repo.findByUsername(username);
    }
}

