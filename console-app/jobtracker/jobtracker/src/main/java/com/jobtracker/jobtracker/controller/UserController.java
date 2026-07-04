package com.jobtracker.jobtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.jobtracker.model.User;
import com.jobtracker.jobtracker.service.UserService;

@RestController
@RequestMapping("/auth") 
public class UserController {
    @Autowired
    UserService service;
     @PostMapping("/register")
    public User register(@RequestBody User user) {
      
       return service.saveUser(user);
    }
    @PostMapping("/login")
public User login(@RequestBody User user) {
    return service.login(user.getEmail(), user.getPassword());
}

}


