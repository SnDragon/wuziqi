package com.crm.socket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;

import com.crm.model.HallChatRecord;
import com.crm.service.UserService;
import com.crm.util.Message;
import com.crm.util.UserUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@ServerEndpoint(value="/websocket")
public class WebSocket {
	
	//@Resource
	private UserService userService=ContextLoader.getCurrentWebApplicationContext().getBean(UserService.class);;
	
	private static Gson gson=new Gson();
	
	private static final Logger logger=LoggerFactory.getLogger(WebSocket.class);
	//保存每个session的信息<userId,session>
	public static Map<Integer, Session> sessions=new HashMap<Integer,Session>();
	//保存每个用户的信息<用户id,用户>
	public static Map<Integer,UserUtil> userList=new HashMap<Integer,UserUtil>();
	@OnOpen
	public void onOpen(Session session,EndpointConfig config){
		logger.info(getTime()+"与客户端建立连接，客户id:"+session.getId());
	}
	
	@OnMessage
	public void OnMessage(String message,Session session) throws IOException{
		logger.info("接收到来自session id:"+session.getId()+"的请求");
		System.out.println(message);
		Message message2=gson.fromJson(message, Message.class);
		System.out.println(message2.getType());
		int type=message2.getType();
		switch (type) {
		//用户登录
		case 1:
			System.out.println("新用户登录...");
			
			
			
			
			//返回给该用户当前在线用户列表
			Collection<UserUtil> collection=userList.values();
			String userListStr=gson.toJson(collection);
			System.out.println(userListStr);
			Message<Collection<UserUtil>> userListMessage=new Message<>();
			//Type1.返回在线用户列表
			userListMessage.setType(1);
			userListMessage.setContent(collection);
			String onlineUserList=gson.toJson(userListMessage);
			System.out.println(onlineUserList);
			session.getBasicRemote().sendText(onlineUserList);
			
			
			Message<UserUtil> userMessage=gson.fromJson(message, new TypeToken<Message<UserUtil>>(){}.getType());
			UserUtil user=userMessage.getContent();
			System.out.println(user);
			//Type2:返回刚上线用户信息
			userMessage.setType(2);
			String loginUserStr=gson.toJson(userMessage);
			//通知其他用户该用户上线
			for(Session s:sessions.values()){
				if(s.isOpen()){
					s.getBasicRemote().sendText(loginUserStr);
				}
			}
			//将新用户添加到用户列表跟会话列表中
			sessions.put(user.getUserId(), session);
			userList.put(user.getUserId(), user);
			//更新用户状态,离线->在线
			userService.updateUserStatus(user.getUserId(), 1);
			System.out.println(userService);
			break;
			
		//用户往大厅发送信息
		case 2:
			Message<HallChatRecord> hallCRM=gson.fromJson(message, new TypeToken<Message<HallChatRecord>>(){}.getType());
			String senderSessionId=session.getId();
			logger.info("id为:"+senderSessionId+"的用户发送了一条信息");
			hallCRM.setType(3);
			String result=gson.toJson(hallCRM);
			for(Session s:sessions.values()){
				if(s.isOpen() && !s.getId().equals(senderSessionId)){
					s.getBasicRemote().sendText(result);
				}
			}
			break;
		//用户离线
		case 3:
			logger.info("用户id为:"+session.getId()+"下线了");
			Message<UserUtil> userMessage2=gson.fromJson(message, new TypeToken<Message<UserUtil>>(){}.getType());
			UserUtil user2=userMessage2.getContent();
			//将用户从用户列表和会话列表移除
			userList.remove(user2.getUserId());
			sessions.remove(user2.getUserId());
			//通知其他用户改用户下线
			userMessage2.setType(4);
			
			for(Session s:sessions.values()){
				if(s.isOpen()){
					s.getBasicRemote().sendText(gson.toJson(userMessage2));
				}
			}
			
			//更新用户状态
			userService.updateUserStatus(user2.getUserId(), 0);
			break;
		default:
			break;
		}
		
		
	}
	
	
	@OnError
	public void onError(Session session,Throwable throwable){
		logger.error("服务器出错,出错的session Id为:"+session.getId());
	}
	
	@OnClose
	public void onClose(Session session,CloseReason closeReason) throws IOException{
		Message<UserUtil> offlineUM=new Message<>();
		for(Map.Entry<Integer, Session> entry:sessions.entrySet()){
			if(entry.getValue().getId().equals(session.getId())){
				UserUtil userUtil=userList.get(entry.getKey());
				offlineUM.setType(3);
				offlineUM.setContent(userUtil);
				break;
			}
		}
		String string=gson.toJson(offlineUM);
		System.out.println(string);
		OnMessage(string,session);
		System.out.println(session.getId()+"关闭了连接");
	}
	
	
	public String getTime(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	
}
