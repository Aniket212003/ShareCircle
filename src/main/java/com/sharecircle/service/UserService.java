package com.sharecircle.service;

import com.sharecircle.entities.User;
import com.sharecircle.enums.UserStatus;

public interface UserService 
{
	public abstract UserStatus addUser(User user);
	public abstract Boolean checkUser(String userName);
	public abstract String verifyUser(String email, String password);
}
