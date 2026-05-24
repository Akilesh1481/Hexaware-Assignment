package com.app.service;

import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public void insertUser(User user) {
        repository.insertUser(user);
    }

    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    public void deleteUser(int id) {
        repository.deleteUser(id);
    }
}