package com.crm.util;

import com.crm.model.User;

public class UserUtil2 {
	private User user;
	private boolean isFriend;
	
	
	
	
	@Override
	public String toString() {
		return "UserUtil2 [user=" + user + ", isFriend=" + isFriend + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isFriend() {
		return isFriend;
	}
	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}
	
	
	
}
