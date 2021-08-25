package com.felix.atmSim.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felix.atmSim.dao.RoleDao;
import com.felix.atmSim.dao.UserDao;
import com.felix.atmSim.entity.Role;
import com.felix.atmSim.entity.User;
import com.felix.atmSim.user.CrmUser;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// from UserDetailsService (superclass of UserService) - checks the credentials for login from the persistence layer
	// called when the user submits the login form (form with input name="username" and name="password")
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String accountNumber) throws UsernameNotFoundException {
		User theUser = userDao.findByAccountNumber(accountNumber);
		if(theUser == null)
			throw new UsernameNotFoundException("Invalid account number or pin number.");
		// params - username, password, authorities that should be granted to the caller if they present the correct username and password (Collection)
		// null collection will throw exception (3rd param)
		return new org.springframework.security.core.userdetails.User(theUser.getAccountNumber(), theUser.getPinNumber(), 
				mapRolesToAuthorities(theUser.getRoles()));
	}

	@Override
	@Transactional
	public User findByAccountNumber(String accountNumber) {
		return userDao.findByAccountNumber(accountNumber);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User newUser = new User();
		
		newUser.setAccountNumber(crmUser.getAccountNumber());
		newUser.setPinNumber(passwordEncoder.encode(crmUser.getPinNumber()));
		newUser.setFirstName(crmUser.getFirstName());
		newUser.setLastName(crmUser.getLastName());
		newUser.setCheckingBalance(0);
		newUser.setSavingBalance(0);
		// inserts a single Role object into an Array
		// since the new user's credentials have been verified by the CrmUser class,
		// we can assign the role of 'CUSTOMER' to the new user
		newUser.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_CUSTOMER")));
		
		userDao.save(newUser);
	}
	
	@Override
	@Transactional
	public void update(User theUser, boolean rehashPin) {
		if(rehashPin)
			theUser.setPinNumber(passwordEncoder.encode(theUser.getPinNumber()));
		userDao.save(theUser);
	}
	
	// returns a collection of authorities granted to an Authentication object
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
