package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class UserDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column
	private String userName;
	@Column
	private String emailAddress;
	@Column
	private String passwordBeforeHashing;
	@Column
	private String password;
	@Column
	private double height;
	@Column
	private double waist;
	@Column
	private double targetWeight;
	@Column
	private int point;
	
	

}
