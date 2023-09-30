package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.BodyData;
import com.example.service.BodyDataService;



@Controller
@RequestMapping("/bodydata")
public class BodyDataController {
	
	@Autowired
	private BodyDataService bodydataservice;
	
	@GetMapping("/list")
public String getUserList(Model model) {
		
		// テーブル(M_USER)から全項目を取得
		List<BodyData> bodyDataList = bodydataservice.getAllBodyData();
		
		// Modelに登録
		model.addAttribute("bodyDataList", bodyDataList);
		
        //list.htmlの呼び出し
		return "/bodydata/list";
	}

}
