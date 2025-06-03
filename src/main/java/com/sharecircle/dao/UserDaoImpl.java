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
		Transaction txn = null;
		try(Session session = sessionFactory.openSession())
		{			
			txn = session.beginTransaction();
			session.save(user);
			txn.commit();
			
			return UserStatus.SUCCESS;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			txn.rollback();
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

	@Override
	public String verifyUser(String email, String password) 
	{
		try(Session session = sessionFactory.openSession())
		{
			Query<String> query = session.createQuery("SELECT userName FROM User WHERE userEmail= :uemail AND password= :upassword", String.class);
			query.setParameter("uemail", email);
			query.setParameter("upassword", password);
			
			List<String> list = query.list();
			
			if(list.isEmpty())
			{
				return null;
			}
			
			return list.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getUserID(String userName)
	{
		try(Session session = sessionFactory.openSession())
		{
			Query<Integer> userId = session.createQuery("SELECT userId FROM User WHERE userName= :uname", Integer.class);
			userId.setParameter("uname", userName);
			
			List<Integer> list = userId.list();
			
			if(list.isEmpty())
			{	
				return null;
			}
			
			return list.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUserDeatils(Integer userId) 
	{
		try(Session session = sessionFactory.openSession())
		{
			User user = session.get(User.class, userId);
			
			if(user == null)
			{	
				return null;
			}
			
			return user;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public UserStatus updateUser(User user) 
	{
		Transaction txn = null;
		try(Session session = sessionFactory.openSession())
		{
			txn = session.beginTransaction();
			session.saveOrUpdate(user);
			txn.commit();
			
			return UserStatus.UPDATE_SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			txn.rollback();
			return UserStatus.UPDATE_FAILURE;
		}
	}

	@Override
	public UserStatus resetPassword(String userName, String newPassword) 
	{
		Transaction txn = null;
		try(Session session = sessionFactory.openSession())
		{
			Query<?> query = session.createQuery("UPDATE User SET password= :pass WHERE userName= :uname");
			query.setParameter("pass", newPassword);
			query.setParameter("uname", userName);
			
			txn = session.beginTransaction();
			query.executeUpdate();
			txn.commit();
			
			return UserStatus.UPDATE_SUCCESS;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			txn.rollback();
			return UserStatus.UPDATE_FAILURE;
		}
	}

}
