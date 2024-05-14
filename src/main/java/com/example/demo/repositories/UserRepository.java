package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);

}