package com.ttq.dao;

import com.ttq.entity.User;

public interface UserDao {
	//根据用户名查询用户
	User selectByUsername(String username);

	//添加用户
	boolean insertUser(User user);

	//根据用户名和密码操作
	User selectByUsernameAndPassword(String username, String password);

}
