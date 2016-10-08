package com.hanbit.spring.core.session;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SessionHelper {
	
	private static SessionHelper SESSION_HELPER;	// static method에서 접근하기위해 자기 자신 객체를 만듦
	
	@Autowired
	private ApplicationContext applicationContext;

	// 스프링이 이 클래스를 bean으로 등록한 다음에 생성되는 시점에서 자기 자신을 변수에 넣음
	@PostConstruct
	public void initSessionHelper() {
		SESSION_HELPER = this;
	}
	
	private HttpSession session;


	public void setSession(HttpSession session) {
		SESSION_HELPER.applicationContext.getBean(SpringSession.class).setSession(session);
	}

	public static HttpSession getSession() {	// static 메소드는 unstatic 객체를 사용할 수 없음
		return SESSION_HELPER.applicationContext.getBean(SpringSession.class).getSession();
		// scope 이 같은 세션이므로
	}
	
	
}
