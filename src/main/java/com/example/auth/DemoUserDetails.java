package com.example.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.UserAccount;

public class DemoUserDetails implements UserDetails {
	
	private final UserAccount user;
	
	public DemoUserDetails(UserAccount user) {
		this.user =user; 
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return this.user.password();
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return this.user.emailAddress();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

}
