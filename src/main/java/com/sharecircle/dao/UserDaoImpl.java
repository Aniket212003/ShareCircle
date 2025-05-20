package com.sharecircle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sharecircle.entities.User;
import com.sharecircle.enums.UserStatus;
import com.sharecircle.util.HibernateUtil;

public class UserDaoImpl implements UserDao
{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public UserStatus addUser(User user) 
	{
		try(Session session = sessionFactory.openSession())
		{			
			Transaction txn = session.beginTransaction();
			session.save(user);
			txn.commit();
			
			return UserStatus.SUCCESS;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return UserStatus.FAILURE;
		}
	}

	@Override
	public Boolean checkUser(String userName) 
	{
		try(Session session = sessionFactory.openSession())
		{
			Query<String> query = session.createQuery("Select userName FROM User WHERE userName= :uname", String.class);
			query.setParameter("uname", userName);
				
			List<String> list = query.list();
				
			return !list.isEmpty();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//return null;
		}
		return false;
	}

}
