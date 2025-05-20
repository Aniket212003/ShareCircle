package com.sharecircle.dao;

import com.sharecircle.entities.User;
import com.sharecircle.enums.UserStatus;

public interface UserDao 
{
	public abstract UserStatus addUser(User user);
	public abstract Boolean checkUser(String userName);
}
