package com.crm.util;

public class UserUtil {
	private int userId;
	private String userName;
	private int userStatus;
	
	
	
	@Override
	public String toString() {
		return "UserUtil [userId=" + userId + ", userName=" + userName + ", userStatus=" + userStatus + "]";
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
