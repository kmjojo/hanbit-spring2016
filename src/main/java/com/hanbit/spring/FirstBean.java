package com.hanbit.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//이 어노테이션을 사용하면 xml config에 bean을 등록하지 않아도 됨
@Component
public class FirstBean {
	
	private static final Logger logger = LoggerFactory.getLogger(FirstBean.class);

	// first와 second 간의 의존성
	@Autowired
	private SecondBean secondBean;  
	
	private int value;
	
	public void callSecondBean() {
		logger.debug("logger test");
		logger.info("" + value++);
		secondBean.printName();
	}  

}
