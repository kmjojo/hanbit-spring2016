package com.hanbit.spring.core.session;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 세션을 저장할 Bean
 * @author 1027
 * 오후 5:26:47
 */
@Component
@Scope("session")
public class SpringSession {

	private HttpSession session;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	
}
