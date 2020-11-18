package com.wyu.StudentInfoSys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
	
	
	/**
	   *     用户登陆功能
	 * @param user
	 * @param session
	 * @param response
	 * @return
	 */
	@PostMapping("/user/login")
	@CrossOrigin
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
			System.out.println("现在是登陆页面");
			return map;
	}
	
	/**
	    *    用户注册功能
	 * @param user
	 * @param session
	 * @param response
	 * @return
	 */
	@PostMapping("/user/register")
	@CrossOrigin
	public Map<String, Object> register(@RequestBody User user,
							         HttpSession session,
							         HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//验证输入的用户名或密码是否为空
		if (StringUtils.isEmpty(user.getUserId()) || StringUtils.isEmpty(user.getPassword())) {
            map.put("msg", "用户名和密码不能为空");
            return map;
        }
		
        User exsitUser = userService.getUserById(user.getUserId());
        // 验证用户名是否已经注册
        if (exsitUser != null) {
            map.put("msg", "该用户名已存在!");
            return map;
        }
        user.setUserId(user.getUserId());
        user.setUserName(user.getUserName());
        user.setPhoneNum(user.getPhoneNum());
        user.setMail(user.getMail());
        user.setPassword(user.getPassword());
        
        //判断是否注册成功
        boolean count = userService.saveUser(user);
        System.out.println(count);
        if (count == false) {
            map.put("msg", "注册失败");
            return map;
        }
        map.put("msg", "注册成功");
        return map;
		
	}
	
	@PostMapping("/user/update")
	@CrossOrigin
	public Map<String, Object> updateUser(@RequestBody User user,
							         HttpSession session,
							         HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		user.getUserId();
        user.setUserName(user.getUserName());
        user.setPhoneNum(user.getPhoneNum());
        user.setMail(user.getMail());
        user.setPassword(user.getPassword());
        
        boolean count = userService.updateUser(user);
        System.out.println(count);
        if (count == false) {
            map.put("msg", "修改失败");
            return map;
        }
        map.put("msg", "修改成功");
        return map;
		
	}
}