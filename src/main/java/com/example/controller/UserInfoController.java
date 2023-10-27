package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.UserInfoForm;
import com.example.model.GroupOrder;
import com.example.model.SignupForm;
import com.example.model.UserInfo;
import com.example.service.UserInfoService;

@RequestMapping("")
@Controller
public class UserInfoController {
	
	@Autowired
	private UserInfoService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/signup")
	public String getSignup(Model model,@ModelAttribute SignupForm form) {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(Model model,@Validated(GroupOrder.class) @ModelAttribute SignupForm form
			,BindingResult bindingResult) {
		// 入力チェック
		if(bindingResult.hasErrors()) {
			// エラーが発生したので登録画面に戻る
			return getSignup(model,form);
		}
		
		//formをUserInfoクラスに変換
		UserInfo userinfo = mapper.map(form, UserInfo.class);
		
		//ユーザー登録
		service.signUp(userinfo);

		// ログイン画面にリダイレクト
		return "redirect:/login";
	}
	
	
	
	@PostMapping("/userinfo")
	public String userInfo(UserInfoForm form,Model model){
		
		String userEmailAddress = SecurityContextHolder.getContext().getAuthentication().getName();
		
		//ユーザー情報を1件取得
		UserInfo userinfo = service.getOneUserInfo(userEmailAddress);
		
		//UseInfoをformに変換
		form = mapper.map(userinfo, UserInfoForm.class);
		
		model.addAttribute("userInfoForm", form);
		
		return "userinfo";
		
	}
	
	
	@PostMapping("/userinfo/{emailAddress:.+}")
	public String userInfo(UserInfoForm form,Model model,@PathVariable("emailAddress")String EmailAddress){
		
		//ユーザー情報を1件取得
		UserInfo userinfo = service.getOneUserInfo(EmailAddress);
		
		//UseInfoをformに変換
		form = mapper.map(userinfo, UserInfoForm.class);
		
		model.addAttribute("userInfoForm", form);
		
		return "userinfo";
		
	}
	
	
}
