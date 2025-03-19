package com.insurance.project.ui.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.insurance.project.ui.model.Policy;

/*
 * Repository interface for performing CRUD operations on the Claim entity.
 * Extends JpaRepository to provide built-in database operations.
 */
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
	
    List<Policy> findByUserUserId(Long userId); // Note the nested property reference

}
