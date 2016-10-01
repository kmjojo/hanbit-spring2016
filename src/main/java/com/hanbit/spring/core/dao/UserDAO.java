package com.hanbit.spring.core.dao;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.spring.core.vo.UserVO;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public int insertUser(UserVO userVO) {
		
		try (Connection connection = dataSource.getConnection()){
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int insertUserDetail(UserVO userVO) {
		return 0;
	}
	
	@Override
	public int countEmail(String email) {
		return 0;
	}
	
	@Override
	public int updateUser(UserVO userVO) {
		return 0;
	}
	
	@Override
	public String selectPassword(String userId) {
		return null;
	}
	
	@Override
	public int deleteUser(String userId) {
		return 0;
	}
	
	@Override
	public int deleteUserDetail(String userId) {
		return 0;
	}
	
	@Override
	public List<UserVO> selectUsers() {
		return null;
	}
	
	@Override
	public UserVO selectUserDetail(String userId) {
		return null;
	}
	
}
