package com.wyu.StudentInfoSys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.wyu.StudentInfoSys.entity.Result;
import com.wyu.StudentInfoSys.entity.User;
import com.wyu.StudentInfoSys.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	private Result result;
	
	/**
	   *     用户登陆功能
	 * @param user
	 * @param session
	 * @param response
	 * @return
	 */
	@PostMapping("/user/login")
	@CrossOrigin
	public Result login(@RequestBody User user,
							         HttpSession session,
							         HttpServletResponse response) {
			result = new Result();
			
			User exsitUser = userService.getUserById(user.getUserId());
			System.out.println(user.getUserId());
			if (StringUtils.isEmpty(user.getUserId()) || StringUtils.isEmpty(user.getPassword())) {
				result.setResult("用户ID或密码为空");
				return result;
	        }
			if (exsitUser == null) {
				result.setResult("用户ID不存在");
				return result;
			}
			if (!exsitUser.getPassword().equals(user.getPassword())){
				result.setResult("用户ID或密码输入错误，请重新输入");
				return result;
			}
			session.setAttribute("loginUser", exsitUser);
			result.setResult("登陆成功");
			System.out.println("登陆后----------" + result.getResult());
			result.setUserName(exsitUser.getUserName());
			System.out.println("登陆后用户名为"+result.getUserName());
			result.setUserId(user.getUserId());
			System.out.println("登陆后用户ID----------" + result.getUserId());
			System.out.println("现在是登陆页面");
//			System.out.println(result.getResult());
			return result;
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
	public Result register(@RequestBody User user,
							         HttpSession session,
							         HttpServletResponse response){
		result = new Result();
		System.out.println("-----------");
		System.out.println(user.getUserId()+user.getPassword());
		//验证输入的用户名或密码是否为空
		if (StringUtils.isEmpty(user.getUserId()) || StringUtils.isEmpty(user.getPassword())) {
            result.setResult("用户名和密码不能为空");
			return result;
        }
		
        User exsitUser = userService.getUserById(user.getUserId());
        // 验证用户名是否已经注册
        if (exsitUser != null) {
            result.setResult("该用户名已存在");
			return result;
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
            result.setResult("注册失败");
			return result;
        }
        result.setResult("注册成功");
		return result;
	}
	
	/**用户信息修改功能
	 * @param user
	 * @param session
	 * @param response
	 * @return
	 */
	@PutMapping("/user/update")
	@CrossOrigin
	public Result updateUser(@RequestBody User user,
							         HttpSession session,
							         HttpServletResponse response){
		result = new Result();
		user.getUserId();
		result.setUserId(user.getUserId());
		result.setUserName(user.getUserName());
        user.setUserName(user.getUserName());
        user.setPhoneNum(user.getPhoneNum());
        user.setMail(user.getMail());
        user.setPassword(user.getPassword());
        System.out.println(result.getUserId());
        System.out.println(result.getUserName());
        boolean count = userService.updateUser(user);
        System.out.println(count);
        if (count == false) {
            result.setResult("修改失败");
			return result;
        }
        result.setResult("修改成功");
        result.setUserName(user.getUserName());
		return result;
		
	}
}