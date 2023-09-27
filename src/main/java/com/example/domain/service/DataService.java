package com.example.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.BodyData;
import com.example.domain.repository.DataDao;

@Transactional
@Service
public class DataService {
	@Autowired
	@Qualifier("DataDaoJdbc")
	DataDao dao;
	
	//1件追加用メソッド
	public boolean insert(BodyData bodyData) {
		//insert実行
		int rowNumber = dao.insertOne(bodyData);
		//判定用変数
		boolean result = false;
		if(rowNumber > 0) {
			//insert成功
			result = true;
		}
		return result;
	}
	
	//全件取得用メソッド
	public List<BodyData> selectMany(){
		//全件取得
		return dao.selectMany();
	}
	
	//1件取得用メソッド
	public BodyData selectOne(int id) {
		//selectOne実行
		return dao.selectOne(id);
	}
	
	//1件更新メソッド
	public boolean updateOne(BodyData bodyData) {
		//1件更新
		int rowNumber = dao.updateOne(bodyData);
		//判定用変数
		boolean result = false;
		if(rowNumber > 0) {
			//update成功
			result = true;
		}
		return result;
	}
	
	//1件削除メソッド
	public boolean deleteOne(int id) {
		//1件削除
		int rowNumber = dao.deleteOne(id);
		//判定用変数
		boolean result = false;
		if(rowNumber > 0) {
			//delete成功
			result = true;
		}
		return result;
	}
}
