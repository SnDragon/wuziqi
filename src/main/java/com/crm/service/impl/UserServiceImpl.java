package com.crm.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crm.dao.UserDao;
import com.crm.model.Friend;
import com.crm.model.User;
import com.crm.service.FriendService;
import com.crm.service.UserService;
import com.crm.util.UserUtil;
import com.crm.util.UserUtil2;
import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;
@Service("userService")
public class UserServiceImpl implements UserService {
     @Resource
	private UserDao userDao;
     @Resource
     private FriendService friendService;

	@Override
	public User checkLogin(String username, String password) {
		if(username==null || password==null){
			return null;
		}
		username=username.trim();
		if("".equals(username) || "".equals(password)){
			return null;
		}
		return userDao.findUserByName(username,password);
	}

	@Override
	public boolean register(String username, String password1, String password2) {
		if(username==null || password1==null || password2==null){
			return false;
		}
		username=username.trim();
		password1=password1.trim();
		password2=password2.trim();
		if("".equals(username) || "".equals(password1) || "".equals(password2) || !password1.equals(password2)){
			return false;
		}
		User user=new User(username,password1);
		if(userDao.insertUser(user)>0){
			return true;
		}else{
			return false;
		}
	}


	@Override
	public ArrayList<User> showRankList() {
		return userDao.getRankList();
	}

	@Override
	public boolean updateUserStatus(int uid, int status) {
		if(userDao.updateUserStatus(uid,status)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public UserUtil2 showUserById(Integer userId, Integer uid) {
		User user=userDao.findUserById(uid);
		UserUtil2 userUtil2=new UserUtil2();
		userUtil2.setUser(user);
		if(friendService.isFriend(new Friend(userId,uid))){
			userUtil2.setFriend(true);
		}else{
			userUtil2.setFriend(false);
		}
		
		return userUtil2;
	}


   
}
