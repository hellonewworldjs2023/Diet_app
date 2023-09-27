package com.example.domain.repository.jdbc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.model.BodyData;
import com.example.domain.repository.DataDao;

@Repository("DataDaoJdbc")
public class DataDaoJdbc implements DataDao {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int insertOne(BodyData bodyData) throws DataAccessException {
		LocalDateTime thisTime = LocalDateTime.now();
		bodyData.setUpdated_at(thisTime);		
		int rowNumber = jdbc.update(
				"INSERT INTO sampletb(id," + "name," + "weight," + "fat_per," + "updated_at)"
				+ "VALUES(?,?,?,?,?)",
				bodyData.getId(),bodyData.getName(),bodyData.getWeight(),bodyData.getFat_per(),bodyData.getUpdated_at());
		return rowNumber;
	}

	@Override
	public BodyData selectOne(int id) throws DataAccessException {
		//一件取得
		Integer i = Integer.valueOf(id);
		String str_id = i.toString();
		
		Map<String,Object> map = jdbc.queryForMap("SELECT * FROM sampletb" + " WHERE id = ?",str_id);
		//結果返却用の変数
		BodyData bodyData = new BodyData();
		//取得したデータを結果返却用の変数にセットしていく
		bodyData.setId((Integer)map.get("id"));//id
		bodyData.setName((String)map.get("name"));//名前
		bodyData.setWeight((Double)map.get("weight"));//体重
		bodyData.setFat_per((Double)map.get("fat_per"));//体重
		bodyData.setUpdated_at((LocalDateTime)map.get("updated_at"));//入力日
		return bodyData;
	}

	@Override
	public List<BodyData> selectMany() throws DataAccessException {
		// テーブルのデータを全件取得
		List<Map<String,Object>> getList = jdbc.queryForList("SELECT * FROM sampletb");
		//結果返却用の変数
		List<BodyData> bodyDataList = new ArrayList<>(); 
		//取得したデータを結果返却用のListに格納していく
		for(Map<String,Object> map : getList) {
		//BodyDataインスタンスの作成
			BodyData bodyData = new BodyData();
			//BodyDataインスタンスに取得したデータをセットする
			bodyData.setId((Integer)map.get("id"));//id
			bodyData.setName((String)map.get("name"));//名前
			bodyData.setWeight((Double)map.get("weight"));//体重
			bodyData.setFat_per((Double)map.get("fat_per"));//体重
			bodyData.setUpdated_at((LocalDateTime)map.get("updated_at"));//入力日
			//結果返却用の Listに追加
			bodyDataList.add(bodyData);
		}
		return bodyDataList;
	}
	
	//テーブルを一件更新
	@Override
	public int updateOne(BodyData bodyData) throws DataAccessException {
		// 1件更新
		int rowNumber = jdbc.update(
				"UPDATE sampletb" + " SET" + " name = ?," + " weight = ?," + " fat_per = ?," + " updated_at = ?" + " WHERE id = ?",
				bodyData.getName(),bodyData.getWeight(),bodyData.getFat_per(),bodyData.getUpdated_at(),bodyData.getId());
		return rowNumber;
	}

	@Override
	public int deleteOne(int id) throws DataAccessException {
		//1件削除
		
		Integer i = Integer.valueOf(id);
		String str_id = i.toString();
		
		int rowNumber = jdbc.update("DELETE FROM sampletb WHERE id = ?",str_id);
		return rowNumber;
	}

}
