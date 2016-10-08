package com.hanbit.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.spring.core.service.UserService;
import com.hanbit.spring.core.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/list")
	@ResponseBody
	public List<UserVO> listUsert() {
		return userService.listUsers();
	}
}
