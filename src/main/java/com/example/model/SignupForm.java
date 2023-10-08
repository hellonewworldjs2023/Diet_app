package com.example.model;

import lombok.Data;

@Data
public class SignupForm {

	private Integer userId;
	
	private String userName;
	
	private String emailAddress;
	
	private String passwordBeforeHashing;
	
	private String password;
	
	private Double height;
	
	private Double waist;
	
	private Double targetWeight;
	
	private Integer point;
	
}
