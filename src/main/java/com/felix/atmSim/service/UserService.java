package com.felix.atmSim.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.felix.atmSim.entity.User;
import com.felix.atmSim.user.CrmUser;

// UserDetailsService - used throughout the framework as a user DAO
public interface UserService extends UserDetailsService {
	
	User findByAccountNumber(String accountNumber);
	
	void save(CrmUser crmUser);
	
	void update(User theUser, boolean rehashPin);

}
