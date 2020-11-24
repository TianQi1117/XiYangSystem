package com.ttq.service;

import java.util.List;

import com.ttq.entity.HelpPrint;
import com.ttq.entity.OldNoHelp;
import com.ttq.entity.OldUserHelpPrint;
import com.ttq.entity.User;

public interface UserService {
	//登录
	User login(String username, String password);

	//注册
	boolean register(User user);

	//查看需要帮扶的老人信息
	List<OldNoHelp> showNeedHelpOld();

	//帮扶老人
	boolean addHelpOld(int oldId, int userId);

	//查询已经帮扶的老人
	List<OldUserHelpPrint> selectOldByUserId(int userId);

	//记录帮扶事件
	boolean addHelp(int userId, int oldId, String helpDescription);

	//查看自己的帮扶事件
	List<HelpPrint> showHelp(int userId);

}
