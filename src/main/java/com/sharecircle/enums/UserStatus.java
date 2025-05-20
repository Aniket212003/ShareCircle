package com.sharecircle.enums;

public enum UserStatus 
{
	SUCCESS("Account Created Successfully"),
	FAILURE("Unable to Created Account"),
	EXISTS("User Allready Exists");
	
	private final String message;
	
	UserStatus(String message)
	{
		System.out.println("Hello called Enum !!!");
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
}
