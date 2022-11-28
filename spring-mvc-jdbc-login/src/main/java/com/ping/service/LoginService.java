package com.ping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ping.dao.UserDao;
import com.ping.dto.UserDto;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public UserDto getUserByUsernameAndPassword(String username, String password) {
		return userDao.getUserByUsernameAndPassword(username, password);
		
	}
}
