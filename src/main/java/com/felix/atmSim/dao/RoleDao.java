package com.felix.atmSim.dao;

import com.felix.atmSim.entity.Role;

public interface RoleDao {
	
	public Role findRoleByName(String name);

}
