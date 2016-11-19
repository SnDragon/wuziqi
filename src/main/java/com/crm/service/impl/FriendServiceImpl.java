package com.crm.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crm.dao.FriendDao;
import com.crm.model.ChatRecord;
import com.crm.model.Friend;
import com.crm.service.ChatRecordService;
import com.crm.service.FriendService;
import com.crm.util.UserUtil;

@Service("friendService")
public class FriendServiceImpl implements FriendService{

	@Resource
	private ChatRecordService chatRecordServie;
	@Resource
	private FriendDao friendDao;
	
	@Override
	public boolean addFriend(Friend friend) {
		if(friendDao.addFriend(friend)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean removeFriend(Friend friend) {
		if(friendDao.removeFriend(friend)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isFriend(Friend friend) {
		if(friendDao.isFriend(friend)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean sendMessage(ChatRecord chatRecord) {
		//往对方发送一条消息
		
		if(chatRecordServie.addChatRecord(chatRecord)){
			return true;
		}
		
		return false;
	}

	@Override
	public ArrayList<UserUtil> getFriendsByUId(Integer uid) {
		if(uid==null){
			return null;
		}
		return friendDao.getFriendsByUId(uid);
	}

}
