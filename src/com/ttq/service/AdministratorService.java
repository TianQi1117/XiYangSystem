package com.ttq.service;

import java.util.List;

import com.ttq.entity.Administrator;
import com.ttq.entity.Old;
import com.ttq.entity.OldAdminPrint;

public interface AdministratorService {
	//注册
	boolean register(Administrator administrator);

	//登录
	Administrator login(String adminName, String password);

	//录入老人信息
	boolean addOld(Old old);

	//查看老人信息
	List<OldAdminPrint> showOld();

	//删除老人信息
	boolean deleteOld(int oldId);

	//修改老人信息
	boolean updateOld(int oldId, int oldAge, String address, String contact);

	//获得某个老人
	Old selectOldById(int oldId);
}
