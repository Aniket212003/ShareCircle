package com.sharecircle.dto;

import com.sharecircle.entities.User;
import com.sharecircle.entities.UserProfile;

public class UserProfileDTO 
{
	//User.java 
	private Integer userId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String userName;
	private String userEmail;
	private Long userPhoneNumber;
	private String password;
	private String createdAt;
	
	//UserProfile.java 
	//private Integer profileId;
	private String profileURL;
	private String location;
	private String bio;
	
	public UserProfileDTO(){}
	
	public UserProfileDTO(User user)
	{
		this.userId = user.getUserId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.fullName = user.getFirstName() + " " + user.getLastName();
		this.userName = user.getUserName();
		this.userEmail = user.getUserEmail();
		this.userPhoneNumber = user.getUserPhoneNumber();
		this.createdAt = user.getCreatedAt();
		
		UserProfile userProfile = user.getUserProfile();
		
		if(userProfile != null)
		{
			this.profileURL = userProfile.getProfileURL();
			this.location = userProfile.getLocation();
			this.bio = userProfile.getBio();
		}
	}

	public Integer getUserId() {
		return userId;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(Long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
	
}
