package com.crm.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.model.User;
import com.crm.service.UserService;
import com.crm.util.UserUtil2;



@Controller
@Scope(value="prototype")
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	@ResponseBody
	public String doLogin(HttpServletRequest request){
		String userName=request.getParameter("account");
		String password=request.getParameter("pass");
		System.out.println(userName+" "+password);
		User user=userService.checkLogin(userName, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			return "success";
		}else{
			return "fail";
		}
	}
	
	@RequestMapping(value="/doRegister",method=RequestMethod.POST)
	@ResponseBody
	public String doRegister(HttpServletRequest request){
		String account=request.getParameter("account");
		String pass1=request.getParameter("pass1");
		String pass2=request.getParameter("pass2");
		System.out.println(account+" "+pass1+" "+pass2);
		if(userService.register(account, pass1, pass2)){
			return "success";
		}else{
			return "fail";
		}
		
	}
	
	@RequestMapping(value="/{uid}",method=RequestMethod.GET)
	@ResponseBody
	public UserUtil2 showUser(@PathVariable("uid")Integer uid,HttpServletRequest request){
		String userId=request.getParameter("userId");
		return userService.showUserById(Integer.parseInt(userId),uid);
	}
	
	@RequestMapping(value="userRanks",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<User> showRankList(){
		return userService.showRankList();
	}
}
