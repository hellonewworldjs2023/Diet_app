package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.UserInfoMapper;
import com.example.model.UserInfo;
import com.example.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper mapper;

	@Override
	public void signUp(UserInfo userinfo) {
		mapper.insertOneUserInfo(userinfo);

	}

	@Override
	public UserInfo getOneUserInfo(String emailAddress) {
		return mapper.findOneUserInfo(emailAddress);
	}

}
