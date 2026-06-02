package com.jobtracker.jobtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobtracker.jobtracker.model.User;
import com.jobtracker.jobtracker.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;
    public User saveUser(User user) {
        return repo.save(user);
    }
    public List<User> getAllUsers() {
        return repo.findAll();

    }
    public User login(String email, String password) {
    return repo.findByEmailAndPassword(email, password);
   
}
}
