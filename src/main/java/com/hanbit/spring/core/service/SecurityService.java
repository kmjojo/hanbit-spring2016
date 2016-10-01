package com.hanbit.spring.core.service;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * desc : 암호화
 * @author 조ㅕ밈
 *
 */
@Service
public class SecurityService {
	
	private static PasswordEncoder encoder;
	/*
	1. private static PasswordEncoder encoder = new StandardPasswordEncoder();
	
	2.
	 static {
	 	encoder = new StandardPasswordEncoder();
	 	eencoder = new StandardPasswordEncoder();
	 }
	 */
	 @PostConstruct	// 스프링이 new 직후에 실행되게
	 public void initEncoder() {
	 	encoder = new StandardPasswordEncoder();
	 }
	 
	
	public String encryptPassword(String rawPassword) {
		
		String encryptPassword = encoder.encode(rawPassword);
		
		return encryptPassword;
	}
	
	public boolean matchPassword(String rawPassword, String encryptPassword) {
		
		return encoder.matches(rawPassword, encryptPassword);
	}
}
