package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.UserInfo;

@Mapper
public interface UserInfoMapper {
	
	public int insertOneUserInfo(UserInfo userinfo);
	
	public UserInfo findOneUserInfo(String emailAddress);

}
