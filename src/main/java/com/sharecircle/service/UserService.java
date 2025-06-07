package com.sharecircle.service;

import com.sharecircle.dto.UserProfileDTO;
import com.sharecircle.entities.User;
import com.sharecircle.enums.UserStatus;

public interface UserService 
{
	public abstract UserStatus addUser(User user);
	public abstract Boolean checkUser(String userName);
	public abstract String verifyUser(String email, String password);
	public abstract Integer getUserId(String userName);
	public abstract UserProfileDTO getUserDetails(Integer userId);
	public abstract User getUserDeatils(Integer userId);
	public abstract UserStatus updateUserProfile(UserProfileDTO userDTO);
	public abstract UserStatus resetPassword(String userName, String newPassword);
}
