package com.crm.service;

import java.util.ArrayList;

import com.crm.model.ChatRecord;
import com.crm.model.Friend;
import com.crm.util.UserUtil;

public interface FriendService {
	public boolean addFriend(Friend friend);

	public boolean removeFriend(Friend friend);
	
	public boolean isFriend(Friend friend);

	public boolean sendMessage(ChatRecord chatRecord);
	
	public ArrayList<UserUtil> getFriendsByUId(Integer uid);
}
