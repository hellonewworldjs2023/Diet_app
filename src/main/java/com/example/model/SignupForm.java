package com.example.model;

import java.util.Objects;

import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

@Data
public class SignupForm {

	private Integer userId;
	
	private String userName;
	
	private String emailAddress;
	
	private String passwordBeforeHashing;
	
	private String passwordBeforeHashingForCheck;
	
	private String password;
	
	private Double height;
	
	private Double waist;
	
	private Double targetWeight;
	
	private Integer point;
	
	//パスワードとチェック用のパスワードを比較し、一致してればtrueを返す。
	@AssertTrue(message="パスワードが一致しません")
	public boolean isPasswordEqual() {
		return Objects.equals(passwordBeforeHashing,passwordBeforeHashingForCheck);
		
	}
}
