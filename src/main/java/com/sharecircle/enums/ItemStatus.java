package com.sharecircle.enums;

public enum ItemStatus 
{
	ADDED_SUCCESSFULLY("Item Addes Successfully!"),
	FAILED("Failed to Add item!"),
	FAILURE("Somthing went wrong");
	
	private final String message;
	
	ItemStatus(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
}
