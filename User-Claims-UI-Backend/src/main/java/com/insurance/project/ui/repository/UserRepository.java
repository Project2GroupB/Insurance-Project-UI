package com.insurance.project.ui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.project.ui.model.User;

/*
 * Repository interface for performing CRUD operations on the User entity.
 * Extends JpaRepository to provide built-in database operations.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
