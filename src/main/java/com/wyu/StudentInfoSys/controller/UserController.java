package com.wyu.StudentInfoSys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wyu.StudentInfoSys.entity.User;
import com.wyu.StudentInfoSys.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/login")
	public Map<String, Object> login(@RequestBody User user,
							         HttpSession session,
							         HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			User exsitUser = userService.getUserById(user.getUserId());
			if (exsitUser == null) {
				map.put("msg", "该用户未注册");
				return map;
			}
			if (!exsitUser.getPassword().equals(user.getPassword() )){
				map.put("msg", "密码错误,请重新输入");
				return map;
			}
			session.setAttribute("loginUser", exsitUser);
			map.put("msg", "登录成功");
			System.out.println("----");
			return map;
	}
}