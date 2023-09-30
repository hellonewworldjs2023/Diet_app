package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.BodyData;

@Mapper
public interface BodyDataMapper {
	
	public List<BodyData> findAllBodyData();

}
