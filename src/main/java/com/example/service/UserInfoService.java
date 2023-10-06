package com.example.service;

import com.example.model.UserInfo;

public interface UserInfoService {
	
	public void signUp(UserInfo userinfo);
	
	public UserInfo getOneUserInfo(String emailAddress);

}
