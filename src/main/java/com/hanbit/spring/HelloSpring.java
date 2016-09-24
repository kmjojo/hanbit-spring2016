package com.hanbit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	


	public static void main(String[] args) {
		System.out.println("HelloSpring");
		
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
