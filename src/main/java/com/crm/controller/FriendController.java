package com.crm.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.model.ChatRecord;
import com.crm.model.Friend;
import com.crm.service.FriendService;
import com.crm.util.UserUtil;

@Controller
@RequestMapping(value="/friend")
public class FriendController {
	
	@Resource
	public FriendService friendService;
	

	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public String ddd(){
		return "hello";
	}
	
	@RequestMapping(value="/addFriend",method=RequestMethod.POST)
	@ResponseBody
	public String addFriend(@RequestBody Friend friend){
		if(friendService.addFriend(friend)){
			return "success";
		}else{
			return "fail";
		}
	}
	
	@RequestMapping(value="/removeFriend",method=RequestMethod.POST)
	@ResponseBody
	public String removeFriend(@RequestBody Friend friend){
		if(friendService.removeFriend(friend)){
			return "success";
		}else{
			return "fail";
		}
	}
	
	@RequestMapping(value="/sendMessage",method=RequestMethod.POST)
	@ResponseBody
	public String sendMessage(@RequestBody ChatRecord chatRecord){
		if(friendService.sendMessage(chatRecord)){
			return "success";
		}else{
			return "fail";
		}
	}
	
	@RequestMapping(value="/friendList/{userId}",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<UserUtil> getFriendList(@PathVariable("userId")Integer uid){
		System.out.println("返回id为"+uid+"的用户列表");
		return friendService.getFriendsByUId(uid);
	}
}
