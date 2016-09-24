package com.hanbit.spring.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.spring.core.dao.ExampleDAO;

@Service
public class ExampleService {
	private final Logger logger = LoggerFactory.getLogger(ExampleService.class);

	@Autowired
	private ExampleDAO exmpleDAO;
	
	public String getText(String text) {
		
		logger.debug(text);
		
		return text;
	}
}
