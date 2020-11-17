package com.wyu.StudentInfoSys.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wyu.StudentInfoSys.entity.User;

@Mapper
public interface UserMapper {
	public User getUserById(String userId);
	public void saveUser(User user);
	public void updateUser(User user);
}
