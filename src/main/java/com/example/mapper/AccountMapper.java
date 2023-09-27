package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.UserAccount;

@Mapper
public interface AccountMapper {
	public UserAccount getAccount(String emailAddress);
}
