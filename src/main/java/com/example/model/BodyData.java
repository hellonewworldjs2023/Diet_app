package com.example.model;



import java.time.LocalDateTime;

import lombok.Data;


@Data
public class BodyData {
	private int id; //ID
	private String name;//ユーザー名
	private double weight;//体重
	private double fatPer;//体脂肪率
	private LocalDateTime createdAt;//入力日

}
