package com.sharecircle.service;

import com.sharecircle.dao.UserDao;
import com.sharecircle.dto.UserProfileDTO;
import com.sharecircle.entities.User;
import com.sharecircle.enums.UserStatus;
import com.sharecircle.factory.UserDaoFactory;

public class UserServiceImpl implements UserService
{
	UserDao userDao = UserDaoFactory.getUserDaoInstance();
	
	@Override
	public UserStatus addUser(User user) 
	{	
		if(user == null)
		{
			throw new NullPointerException("User is Null");
		}
		//String status = userDao.addUser(user);
		return userDao.addUser(user);
	}

	@Override
	public Boolean checkUser(String userName) 
	{
		if(userName == null || userName.isEmpty())
		{
			return false;
		}
		
		return userDao.checkUser(userName);
	}

	@Override
	public String verifyUser(String email, String password) 
	{
		if(email == null || email.isEmpty() || password == null || password.isEmpty())
		{
			return null;
		}
		
		return userDao.verifyUser(email,password); 
	}

	@Override
	public Integer getUserId(String userName) 
	{
		if(userName == null || userName.isEmpty())
		{
			return null;
		}
		
		return userDao.getUserID(userName);
	}

	@Override
	public UserProfileDTO getUserDetails(Integer userId) 
	{
		if(userId == null)
		{
			return null;
		}
		
		User user = userDao.getUserDeatils(userId);
		
		if(user == null)
		{
			return null;
		}
		
		return new UserProfileDTO(user);
	}

}
