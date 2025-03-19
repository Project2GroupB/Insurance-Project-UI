package com.insurance.project.ui.service;

import java.util.List;
import com.insurance.project.ui.model.Policy;

/*
 * Service interface for managing claims.
 * Defines methods for retrieving and adding claims related to users.
 */
public interface PolicyService {

  
    List<Policy> getPolicyByUserId(Long userId);

}
