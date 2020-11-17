package com.wyu.StudentInfoSys.service;

import com.wyu.StudentInfoSys.entity.User;

public interface UserService {
	public User getUserById(String userId);
	public void saveUser(User user);
	public void updateUser(User user);
}
