package com.hanbit.spring.core.session;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")	// 싱글톤으로 사용하면 안됨. 공유하면 안되니까, 스코프 쓰려면 web.xml 설정 필요
public class SessionHelper {

	private HttpSession session;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	
}
