package com.example.form;

import lombok.Data;

@Data
public class UserInfoForm {
	
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
