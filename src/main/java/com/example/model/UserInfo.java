package com.example.model;


import lombok.Data;


@Data
public class UserInfo {
	
	
	private int userId;
	
	private String userName;
	
	private String emailAddress;
	
	private String passwordBeforeHashing;
	
	private String password;
	
	private double height;
	
	private double waist;
	
	private double targetWeight;
	
	private int point;
	
	

}
