package com.crm.dao;

import java.util.ArrayList;

import com.crm.model.Friend;
import com.crm.util.UserUtil;

public interface FriendDao {

	int removeFriend(Friend friend);

	int addFriend(Friend friend);

	int isFriend(Friend friend);

	ArrayList<UserUtil> getFriendsByUId(Integer uid);

}
