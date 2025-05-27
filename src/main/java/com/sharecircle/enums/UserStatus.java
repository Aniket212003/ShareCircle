package com.sharecircle.enums;

public enum UserStatus 
{
	SUCCESS("Account Created Successfully"),
	FAILURE("Unable to Created Account"),
	VALID_USER("Valid User"),
	INVALID_USER("Invalid User Credentials"),
	UPDATE_FAILURE("Unable to Update"),
	UPDATE_SUCCESS("Updated SuccessFully"),
	SOMETHING_WENT_WRONG("Something went wrong");
	
	private final String message;
	
	UserStatus(String message)
	{
		//System.out.println("Hello called Enum !!!");
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
}
