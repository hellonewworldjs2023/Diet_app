package com.example.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.domain.model.BodyData;

public interface DataDao {
	//テーブルにデータを一件insert
	public int insertOne(BodyData bodyData) throws DataAccessException;
	
	//テーブルのデータを一件取得
	public BodyData selectOne(int id) throws DataAccessException;
	
	//テーブルの全データを取得
	public List<BodyData> selectMany() throws DataAccessException;
	
	//テーブルを一件更新
	public int updateOne(BodyData bodyData) throws DataAccessException;
	
	//テーブルを一件削除
	public int deleteOne(int id) throws DataAccessException;
}
