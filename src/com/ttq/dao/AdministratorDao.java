package com.ttq.dao;

import com.ttq.entity.Administrator;

public interface AdministratorDao {
	//根据用户名查询管理员
	Administrator selectByAdminname(String adminname);

	//添加用户
	boolean insertAdmin(Administrator administrator);

	//根据用户名和密码操作
	Administrator selectByAdminnameAndPassword(String adminname, String password);
}
