package com.felix.atmSim.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.felix.atmSim.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByAccountNumber(String accountNumber) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User where account_num=:accountNum", User.class);
		theQuery.setParameter("accountNum", accountNumber);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch(Exception e) {
			theUser = null;
			System.out.println("findByAccountNumber(" + accountNumber + ") exception. print stack trace.");
			e.printStackTrace();
		}
		return theUser;
	}

	@Override
	public void save(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theUser);
	}

}
