package com.users.dto;

public class User {
	static {
		System.out.println("Static block is initiated");
	}
	{
		System.out.println("Non-static block is initiated");
	}
}
