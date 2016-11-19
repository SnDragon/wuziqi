package com.crm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crm.dao.ChatRecordDao;
import com.crm.model.ChatRecord;
import com.crm.service.ChatRecordService;


@Service("chatRecordService")
public class ChatRecordServiceImp implements ChatRecordService{
	
	@Resource
	private ChatRecordDao chatRecordDao;
	
	@Override
	public boolean addChatRecord(ChatRecord chatRecord) {
		if(chatRecordDao.addChatRecord(chatRecord)>0){
			return true;
		}else{
			return false;
		}
	}

}
