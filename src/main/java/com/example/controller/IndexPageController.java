package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.BodyData;
import com.example.model.UserInfo;
import com.example.service.UserInfoService;


@Controller
public class IndexPageController {
	
	@Autowired
	UserInfoService service;

	@RequestMapping("/index")
	public String start(Model model){
		
		String userEmailAddress = SecurityContextHolder.getContext().getAuthentication().getName();
		
		UserInfo userinfo = service.getBodyDataByAddress(userEmailAddress);
		
		List<BodyData> bodyDataList = userinfo.getBodyDatas();
		model.addAttribute("bodyDataList", bodyDataList);
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	

	
	
}
