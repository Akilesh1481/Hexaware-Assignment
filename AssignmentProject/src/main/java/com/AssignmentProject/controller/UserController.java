package com.AssignmentProject.controller;

import com.AssignmentProject.model.User;
import com.AssignmentProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/api/user/all")
    public List<User> getAll(){
        return userService.getAll();
    }
}
