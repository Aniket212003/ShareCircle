package com.sharecircle.dao;


import com.sharecircle.entities.User;
import com.sharecircle.enums.UserStatus;

public interface UserDao 
{
	public abstract UserStatus addUser(User user);
	public abstract Boolean checkUser(String userName);
	public abstract String verifyUser(String email, String password);
	public abstract Integer getUserID(String userName);
	public abstract User getUserDeatils(Integer userId);
	public abstract UserStatus updateUser(User user);
	public abstract UserStatus resetPassword(String userName, String newPassword);
}
