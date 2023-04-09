package com.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.db.HibernateUtil;
import com.entity.User;


public class UserDAO {

	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;

	public UserDAO(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	
	
	public boolean saveUser(User user) {
		
		
		boolean f = false;
		
		
		try {
			
			session = factory.openSession();
			
			tx = session.beginTransaction();
			
			session.save(user);
			
			tx.commit();
			f = true;
			
		} 
		
		catch (Exception e) {
			if(tx != null) {
				f = false;
				e.printStackTrace();
			}
		}
		
		return f;
		
	}
	
	
	public User loginUser(String email, String password) {
		
		
		User u = null;
		
		session = factory.openSession();
		
		Query q = session.createQuery("from User where email =:em and password=:pass");
		
		q.setParameter("em", email);
		q.setParameter("pass", password);
		
		
		u = (User)q.uniqueResult();
		
		
		
		
		
		
		return u;
		
	}
	
	
	
}
