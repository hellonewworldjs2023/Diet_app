package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.BodyData;

@Mapper
public interface BodyDataMapper {
	
	public int insertOne(BodyData bodydata);
	
	
	
	public List<BodyData> findAllBodyData();

}
