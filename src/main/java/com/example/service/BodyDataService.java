package com.example.service;

import java.util.List;

import com.example.model.BodyData;

public interface BodyDataService {
	
	public void inputData(BodyData bodydata);
	
	public List<BodyData> getAllBodyData();

}
