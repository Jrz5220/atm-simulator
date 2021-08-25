package com.felix.atmSim.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.felix.atmSim.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role findRoleByName(String theRoleName) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the role name
		Query<Role> theQuery = currentSession.createQuery("from Role where name=:roleName", Role.class);
		theQuery.setParameter("roleName", theRoleName);
		
		Role theRole = null;
		try {
			// if the role name does not exist in the database (returns null),
			// the user is not a registered customer
			theRole = theQuery.getSingleResult();
		} catch(Exception e) {
			theRole = null;
			e.printStackTrace();
		}
		
		return theRole;
	}

}
