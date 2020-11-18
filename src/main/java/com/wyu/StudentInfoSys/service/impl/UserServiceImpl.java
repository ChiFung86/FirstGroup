package com.wyu.StudentInfoSys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyu.StudentInfoSys.entity.User;
import com.wyu.StudentInfoSys.mapper.UserMapper;
import com.wyu.StudentInfoSys.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(userId);
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.saveUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
		
	}
	
	
}
