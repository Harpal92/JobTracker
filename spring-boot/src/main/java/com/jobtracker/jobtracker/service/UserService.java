package com.jobtracker.jobtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobtracker.jobtracker.model.User;
import com.jobtracker.jobtracker.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    UserRepository repo;
    @Autowired
private PasswordEncoder encoder;
    public User saveUser(User user) {
        user.setPassword(
        encoder.encode(user.getPassword())
    );

    return repo.save(user);
    }
    public List<User> getAllUsers() {
        return repo.findAll();

    }
    public User login(String email, String password) {
      User user=repo.findByEmail( email);
     if(user != null &&
       encoder.matches(password, user.getPassword())) {

        return user;
    }

    return null;
   
}
public User findbyemail(String email){
    return repo.findByEmail(email);
}
}
