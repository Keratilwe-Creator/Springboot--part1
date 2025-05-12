package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    void addUser(User user);
    User getUser(Long id);
    void removeUser(Long id);
}