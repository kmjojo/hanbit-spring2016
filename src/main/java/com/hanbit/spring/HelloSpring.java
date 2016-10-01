package com.hanbit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.hanbit.spring.core.service.ExampleService;
import com.hanbit.spring.core.service.UserService;
import com.hanbit.spring.core.vo.UserVO;

public class HelloSpring {

	public static void main(String[] args) throws Exception {

		// 이 내용은 config에 들어갈듯
		Log4jConfigurer.initLogging("classpath:config/log4j.xml");

		try {
			// applicationContext-core.xml을 참고함
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"spring/applicationContext-core.xml", "spring/applicationContext-dao.xml");

			/*ExampleService exampleService = applicationContext.getBean(ExampleService.class);
			exampleService.getText("Spring");*/
			UserService userService = applicationContext.getBean(UserService.class);
			
			UserVO userVO = new UserVO();
			userVO.setUserId("id");
			userVO.setUserEmail("hi@hi.com");
			userVO.setUserPassword("abcd");
			userVO.setUserTel("123123123");
			
			userService.signUpUser(userVO);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
