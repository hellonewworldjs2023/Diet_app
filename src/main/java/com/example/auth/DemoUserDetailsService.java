package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mapper.AccountMapper;
import com.example.model.UserAccount;

@Service
public class DemoUserDetailsService implements UserDetailsService {

	@Autowired
	AccountMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String userAddress) throws UsernameNotFoundException {
		UserAccount user = mapper.getAccount(userAddress);
		if(user == null) {
			throw new UsernameNotFoundException("not found : " + userAddress);
		}
		return (new DemoUserDetails(user));
	}

}
