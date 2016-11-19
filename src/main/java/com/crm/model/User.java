package com.crm.model;

public class User {
	private Integer userId;
	private String userName;
	private String userPassword;
	private Integer userWinNum;
	private Integer userLoseNum;
	private Integer userTieNum;
	private Integer userIntegral;
	private Integer userStatus;
	
	public User(){
		
	}
	
	public User(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getUserWinNum() {
		return userWinNum;
	}
	public void setUserWinNum(Integer userWinNum) {
		this.userWinNum = userWinNum;
	}
	public Integer getUserLoseNum() {
		return userLoseNum;
	}
	public void setUserLoseNum(Integer userLoseNum) {
		this.userLoseNum = userLoseNum;
	}
	public Integer getUserTieNum() {
		return userTieNum;
	}
	public void setUserTieNum(Integer userTieNum) {
		this.userTieNum = userTieNum;
	}
	public Integer getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	
	
}
