package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.UserInfoMapper;
import com.example.model.UserInfo;
import com.example.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper mapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void signUp(UserInfo userinfo) {
		
		userinfo.setPassword(passwordEncoder.encode(userinfo.getPasswordBeforeHashing()));
		
		mapper.insertOneUserInfo(userinfo);

	}

	@Override
	public UserInfo getOneUserInfo(String emailAddress) {
		return mapper.findOneUserInfo(emailAddress);
	}

	@Override
	@Transactional
	public UserInfo getBodyDataByAddress(String emailAddress) {
		
		return mapper.findByUserAddress(emailAddress);
	}

}
