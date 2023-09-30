package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.model.BodyData;
import com.example.repository.BodyDataMapper;
import com.example.service.BodyDataService;

@Service
public class BodyDataServiceImpl implements BodyDataService {
	
	@Autowired
	private MessageSource messagesource;
	
	@Autowired
	private BodyDataMapper mapper;

	@Override
	public List<BodyData> getAllBodyData() {
		
		return mapper.findAllBodyData();
	}

}
