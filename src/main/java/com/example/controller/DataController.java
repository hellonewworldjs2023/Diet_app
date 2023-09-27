package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.model.BodyData;
import com.example.domain.service.DataService;

@RestController
public class DataController {
	
	@Autowired
	DataService dataService;
	
	//1件追加用メソッド
	@PostMapping("/insert")
	public String insert(@RequestBody BodyData bodydata) {
		String result = "";
		if(dataService.insert(bodydata)) {
			result = "1件追加しました！";
		
		}else{
			result = "追加失敗しました！";
		}
		return result;
	}
	
	//全件取得用メソッド
	@GetMapping("/selectMany")
	public List<BodyData> selectMany(){
		//全件取得
		return dataService.selectMany();
	}
	
	//1件取得用メソッド
	@GetMapping("/selectOne/{id:[0-9]+}")
	public BodyData selectOne(@PathVariable("id") int id) {
		//selectOne実行
		return dataService.selectOne(id);
	}
	
	// 1件更新メソッド
    @PostMapping("/updateOne")
    public String updateOne(@RequestBody BodyData bodyData) {
        String result = "";
        if (dataService.updateOne(bodyData))
            result = "一件更新しました！";
        else
            result = "更新失敗しました！";
        return result;
    }
    
 // 1件削除メソッド
    @PostMapping("/deleteOne/{id:.+}")
    public String deleteOne(@PathVariable("id") int id) {
        String result = "";
        if (dataService.deleteOne(id))
            result = "一件削除しました！";
        else
            result = "削除しました！";
        return result;
    }
}
