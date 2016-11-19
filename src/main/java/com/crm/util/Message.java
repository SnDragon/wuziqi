package com.crm.util;

public class Message<T> {
	private int type;
	private T content;
	
	
	@Override
	public String toString() {
		return "Message [type=" + type + ", content=" + content + "]";
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
	
	
}
