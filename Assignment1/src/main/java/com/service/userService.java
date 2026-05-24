package com.service;

import com.model.user;
import com.repository.userRepository;

import java.sql.SQLException;
import java.util.List;

public class userService {
    userRepository repository = new userRepository();
    public List<user> getAllUser(){
        return repository.getAllUser();
    }

    public List<user> getUserByRole(String city) throws SQLException {
        return repository.getUserByRole(city);
    }

    public void insertUser(user obj){
        repository.insertUser(obj);
    }

    public  void deleteUser(int id){
        repository.deleteUser(id);
    }
}
