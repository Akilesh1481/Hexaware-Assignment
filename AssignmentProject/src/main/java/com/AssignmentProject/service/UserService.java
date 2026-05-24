package com.AssignmentProject.service;

import com.AssignmentProject.model.User;
import com.AssignmentProject.repositroy.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
