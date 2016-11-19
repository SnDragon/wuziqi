package com.crm.service;

import java.util.ArrayList;

import com.crm.model.User;
import com.crm.util.UserUtil;
import com.crm.util.UserUtil2;

public interface UserService {
	
   public User checkLogin(String username,String password);
   
   public boolean register(String username,String password1,String password2);
   
   public UserUtil2 showUserById(Integer userId, Integer uid);
   
   public ArrayList<User> showRankList();
   
   
   public boolean updateUserStatus(int uid,int status);
}
