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
		
		FirstBean oldBean = new FirstBean();
		FirstBean oldBean2 = new FirstBean();
		System.out.println("oldBean: " + oldBean.getValue() + "\toldBean2: " + oldBean2.getValue());

		FirstBean springBean = applicationContext.getBean(FirstBean.class);	// dependency lookup 컨테이너에서 가져옴
		FirstBean springBean2 = applicationContext.getBean(FirstBean.class);
		
		System.out.println("springBean:" + springBean.getValue() + "\tspringBean2: " + springBean2.getValue());
	}

}
