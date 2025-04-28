package com.example.mex1;

// src/main/java/com/example/demo/UserRepository.java

public interface UserRepository {
    boolean existsByUsername(String username);
    void save(User user);
    User findByUsername(String username);
}
