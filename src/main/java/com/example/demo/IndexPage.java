package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexPage {

	@RequestMapping("/index")
	public String start(){
		return "index.html";
	}
	
	@RequestMapping("userInfo")
	public String userInfo(){
		return "userInfo";
		
	}
	
//	@RequestMapping(value="/data",method=RequestMethod.GET)
//	@Transactional
//	@ResponseBody
//	public List<BodyData> bodyData(){
//		List<BodyData> bodyData = 
//				return bodyData;
//	}
	
}
