package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo) { this.repo = repo; }

    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        // Save password as plain text (not recommended for production!)
        user.setRole("USER"); // default role
        userRepository.save(user);
    }

     //@Autowired
    //private UserRepository userRepository;

    //public void register(User user) {
        // Encode password
        //user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set default role
        //user.setRole("USER");

        // Save user
      //  userRepository.save(user);
    //}



    public Optional<User> findByUsername(String username) { return repo.findByUsername(username); }
    //public User save(User user) { return repo.save(user); }
}