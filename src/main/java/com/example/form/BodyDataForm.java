package com.example.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BodyDataForm {
	private int id; //ID
	
	@NotBlank
	private String name;//ユーザー名
	
	@NotBlank
	private double weight;//体重
	
	private double fatPer;//体脂肪率
	
	private LocalDateTime createdAt;//入力日
}
