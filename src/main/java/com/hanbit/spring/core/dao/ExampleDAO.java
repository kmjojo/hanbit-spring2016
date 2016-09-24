package com.hanbit.spring.core.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository	// spring container에 등록됨
public class ExampleDAO {
	private final Logger logger = LoggerFactory.getLogger(ExampleDAO.class);

}
