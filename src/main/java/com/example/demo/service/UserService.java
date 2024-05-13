package com.example.demo.service;

import com.example.demo.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user, BindingResult bindingResult) {
        String username = user.getUsername();
        String email = user.getEmail();

        // Check if username and email already exist
        if (userRepository.existsByUsername(username) && userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Username and email already exist");
        } else if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        } else if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            bindingResult.rejectValue("confirm_password", "error.user", "Passwords do not match");
            return null;
        }

        // Save the user if username and email are unique
        return userRepository.save(user);
    }

    public boolean authenticate(String username, String password) {
            User user = userRepository.findByUsername(username);
            if(user !=null){
                return user.getPassword().equals(password);
            }
            return false;
        }
    }


