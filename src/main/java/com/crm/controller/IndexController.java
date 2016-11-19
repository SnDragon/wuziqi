package com.crm.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.model.User;
import com.crm.service.FriendService;
import com.crm.util.UserUtil;

@Controller
public class IndexController {
	
	@Resource
	private FriendService friendService;
	
	@RequestMapping(value="/")
	public ModelAndView showHome(){
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/game_hall",method=RequestMethod.GET)
	public ModelAndView showGameHall(HttpSession session){
		ModelAndView modelAndView=new ModelAndView("PVP_hall");
//		User user=(User)session.getAttribute("user");
//		ArrayList<UserUtil> friendList=friendService.getFriendsByUId(user.getUserId());
//		modelAndView.addObject("friendList",friendList);
		return modelAndView;
	}
	
	@RequestMapping(value="/PVE",method=RequestMethod.GET)
	public ModelAndView showPVE(){
		return new ModelAndView("PVE");
	}
	
	@ResponseBody
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session){
		session.invalidate();
		return new ModelAndView("redirect:/");
//		return "logout";
	}
}
