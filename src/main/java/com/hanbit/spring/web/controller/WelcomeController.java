package com.hanbit.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

@Controller
public class WelcomeController {
	
	
	@RequestMapping("/")
	public String welcome() {
		
		
		// 실제로는 WEB-INF/jsp/welcome.jsp
		return "welcome";
	}
	
	@RequestMapping("/api/")
	@ResponseBody
	public Map getData(HttpSession session) {
		Map map = new HashMap();
		
		map.put("name", "km");
		map.put("message", "Hello");
		map.put("userEmail", session.getAttribute("userEmail"));
		
		return map;
		
	}

}
