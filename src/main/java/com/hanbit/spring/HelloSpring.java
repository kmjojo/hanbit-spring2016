package com.hanbit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class HelloSpring {
	


	public static void main(String[] args) throws Exception {
		
		// 이 내용은 config에 들어갈듯
		Log4jConfigurer.initLogging("classpath:config/log4j.xml");
		
		/*
		Dependency dp = new Dependency();
		System.out.println(dp.func());
		*/
		
		// applicationContext-core.xml을 참고함
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-core.xml");
		
		FirstBean springBean = applicationContext.getBean(FirstBean.class);	
		springBean.callSecondBean();  

	}

}
