package com.hanbit.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.spring.core.dao.IUserDAO;
import com.hanbit.spring.core.service.UserService;

@Controller
public class SecurityController {
	
	@Resource(name="userDAOImpl")
	private IUserDAO userDAO;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/security/session/test")
	@ResponseBody
	public Map testSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		//session.setAttribute("name", "Hanbit");	// 새로운 세션, 이 줄 주석을 지우고 실행 후 주석 처리 후 실행하면?세션이 유지됐을 때는 네임이 잘 나옴
		// 서버 메모리에서 관리한다
		
		String name = (String) session.getAttribute("name");
		
		Map result = new HashMap();
		result.put("sessionName", name);
		
		return result;
	}
	
	@RequestMapping("/security/signin")
	public Map signIn(@RequestParam("userEmail") String userEmail, @RequestParam("userPw") String userPw, HttpSession session) {
		

		// userDAO.getUserEmailPw();		// DB에 저장된 사용자 정보를 가져옴 (email, pw)
		
		// DB에 있는 Email과 입력된 Email 비교하는 코드
		// 일치하지 않으면 어떻게 처리하는지
		// DB에 없는 값이면 ExampleAOP 클래스에서 받아서 에러 메시지 출력함

		
		// DB에 암호화되어 저장된 비밀번호 가져오는 코드
		
		// DB에 암호화되어 저장된 비밀번호와 일치하는지 확인하는 코드
		// match();
		// 일치하지 않았을 때 처리 코드
		
		// 일치하면
		//session.setAttribute(로그인여부, true)
		//session.setAttribute(이메일)
		
		Map result = new HashMap();
		
		//put()
		
		
		return result;
	}
	
	
	@RequestMapping("/security/signout")
	public void signOut(HttpSession session, HttpServletResponse response) throws Exception {
//		session.removeAttribute("loggedIn");	//하나씩 지우면 처리 시간이 길어지므로 아래 코드로 싹 지워ㅂㅓ린다
		session.invalidate();//싹 지워버림
		
		
		// 1.
		response.sendRedirect("/api/data");	// 301 Redirect 클ㄹㅏ이언트 주소가 바뀜
//		response.getOutputStream().write(); // 클라이언트 페이지에 출력
		// 2.
		// jsp에서는 forwarding으로 처리한다.!!!<- 이게 나을듯? 주소가 안바뀐다고 함
	}
	
	
	
}
