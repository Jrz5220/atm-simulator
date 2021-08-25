package com.felix.atmSim.dao;

import com.felix.atmSim.entity.User;

public interface UserDao {
	
	User findByAccountNumber(String accountNumber);
	
	void save(User theUser);

}
