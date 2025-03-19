package com.insurance.project.ui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.insurance.project.ui.exception.ResourceNotFoundException;
import com.insurance.project.ui.model.Policy;
import com.insurance.project.ui.repository.PolicyRepository;
import com.insurance.project.ui.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

    private static final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

    @Autowired
    private PolicyRepository policyRepository;

	@Override
	public List<Policy> getPolicyByUserId(Long userId) {
		logger.info("Fetching policy deatils for User Id : ", userId);
		List<Policy> policies = policyRepository.findByUserUserId(userId);
		
		if(policies.isEmpty()) {
			logger.warn("Policy not found for User Id : ", userId);
			throw new ResourceNotFoundException("Policy not found for User Id" + userId);
		}
		return policies;
	}	

}
