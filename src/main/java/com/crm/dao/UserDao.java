package com.crm.dao;

import java.util.ArrayList;

import com.crm.model.User;
import com.crm.util.UserUtil;

public interface UserDao {

	public int insertUser(User user);

	public User findUserById(Integer userId);

	public ArrayList<User> getRankList();

	public User findUserByName(String username, String password);

	public int updateUserStatus(int uid, int status);

}
