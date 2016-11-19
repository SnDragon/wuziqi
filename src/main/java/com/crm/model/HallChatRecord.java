package com.crm.model;

public class HallChatRecord {
	private Integer id;
	private Integer senderId;
	private String senderName;
	private String sendTime;
	private String text;
	
	
	
	@Override
	public String toString() {
		return "HallChatRecord [id=" + id + ", senderId=" + senderId + ", senderName=" + senderName + ", sendTime="
				+ sendTime + ", text=" + text + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
