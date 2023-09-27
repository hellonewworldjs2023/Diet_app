package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example"})
@MapperScan(basePackages = "com.example.mapper")
public class DietAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DietAppApplication.class, args);
	}

}
