package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.User;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByUsername(String username);
}
