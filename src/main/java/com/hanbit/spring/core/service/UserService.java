package com.hanbit.spring.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.spring.core.dao.IUserDAO;
import com.hanbit.spring.core.vo.UserVO;

@Service
public class UserService {
	
	@Resource(name="userMybatisDao")
	private IUserDAO userDAO;
	
	@Autowired
	private SecurityService securityService;
	
	public String signUpUser(UserVO userVO) {
		
		String email = userVO.getUserEmail();
		
		if (userDAO.countEmail(email) > 0) {
			throw new RuntimeException("이미 가입된 회원입니다.");
		}
		// TODO 암호화
		String password = userVO.getUserPassword();
		String encryptedPassword = "";
		userVO.setUserPassword(encryptedPassword);
		
		if (userDAO.insertUser(userVO) < 1) {
			throw new RuntimeException("다시 시도하시기 바랍니다.");
		}

		return email;
	}
	
	public boolean modifyUser(UserVO userVO) {

		String userId = userVO.getUserId();
		String currentPassword = userVO.getUserPassword();
		
		String userPassword = userDAO.selectPassword(userId);
		
		// FIXME 암호화 비교
		if (!securityService.matchPassword(currentPassword, userPassword)) {
			throw new RuntimeException("패스워드가 일치하지 않습니다.");
		}

		String newPassword = userVO.getNewPassword();
		String encryptedPassword = securityService.encryptPassword(newPassword);
		
		userVO.setNewPassword(encryptedPassword);
		
		int countUpdated = userDAO.updateUser(userVO);		
		
		return (countUpdated > 0);
	}
	
	// TODO 트랜젝션 처리
	public boolean removeUser(String userId) {
		
		int countDeletedUser = userDAO.deleteUser(userId);
		int countDeletedUserDetail = userDAO.deleteUserDetail(userId);
		
		return (countDeletedUser > 0 && countDeletedUserDetail > 0);
	}
	
	public List<UserVO> listUsers() {
		
		return userDAO.selectUsers();
	}
	
	public UserVO getUserDetail(String userId) {
		
		return userDAO.selectUserDetail(userId);
	}

}
