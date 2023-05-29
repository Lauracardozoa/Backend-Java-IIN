package com.evaluation.backend.repository;

import com.evaluation.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Method used for authentication on login
    Optional<User>findByEmailAndPassword(String email, String password);
}
