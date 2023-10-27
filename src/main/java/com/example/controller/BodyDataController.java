package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.BodyDataForm;
import com.example.model.BodyData;
import com.example.model.GroupOrder;
import com.example.service.BodyDataService;



@Controller
public class BodyDataController {
	
	@Autowired
	private BodyDataService bodydataservice;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//全ての身体データを取得
	@GetMapping("/bodydata/list")
	public String getUserList(Model model) {
		
		// テーブル(sampletb)から全項目を取得
		List<BodyData> bodyDataList = bodydataservice.getAllBodyData();
		
		// Modelに登録
		model.addAttribute("bodyDataList", bodyDataList);
		
        //list.htmlの呼び出し
		return "/bodydata/list";
	}
	
	//身体データ入力画面を表示
	@GetMapping("/inputdata")
	public String goToInputData(@ModelAttribute BodyDataForm form) {
		return "inputdata";
	}

	@PostMapping("/inputdata")
	public String inputData(Model model,Locale locale,
			@Validated(GroupOrder.class) @ModelAttribute BodyDataForm form,
			BindingResult bindingResult) {
		
		//入力チェック
		if(bindingResult.hasErrors()) {
			//エラーが発生したので登録画面に戻る
			return goToInputData(form);
		}
		
		//formをBodyDataクラスに変換
		BodyData bodydata =modelMapper.map(form, BodyData.class);
		
		bodydataservice.inputData(bodydata);
		
		return"/index";
	}
}
