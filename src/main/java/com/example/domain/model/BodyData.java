package com.example.domain.model;



import java.time.LocalDateTime;

import lombok.Data;


@Data
public class BodyData {
	private int id; //ID
	private String name;//ユーザー名
	private double weight;//体重
	private double fat_per;//体脂肪率
	private LocalDateTime updated_at;//入力日

}
