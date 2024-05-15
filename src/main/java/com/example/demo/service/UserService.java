package com.example.demo.service;

import com.example.demo.User;
import com.example.demo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(User user, BindingResult bindingResult) {
        // Validate user input
        String username = user.getUsername();
        String email = user.getEmail();

        if (userRepository.existsByUsername(username)) {
            bindingResult.rejectValue("username", "error.user", "Username already exists");
        }

        if (userRepository.existsByEmail(email)) {
            bindingResult.rejectValue("email", "error.user", "Email already exists");
        }

        // If there are binding errors, return null
        if (bindingResult.hasErrors()) {
            return null;
        }
        // Hash the password before saving it to the database
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);

        // Hash the password before saving it to the database
        String hashedconfirmPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setConfirmPassword(hashedconfirmPassword);

        // Save the user if validation passes
        return userRepository.save(user);
    }


    public boolean authenticate(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.isPresent() && passwordEncoder.matches(password, userOptional.get().getPassword());
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
