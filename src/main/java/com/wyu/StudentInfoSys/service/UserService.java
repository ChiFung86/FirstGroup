package com.wyu.StudentInfoSys.service;

import com.wyu.StudentInfoSys.entity.User;

public interface UserService {
	public User getUserById(String userId);
	public boolean saveUser(User user);
	public boolean updateUser(User user);
}
