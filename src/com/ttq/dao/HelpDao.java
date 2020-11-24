package com.ttq.dao;

import java.util.List;

import com.ttq.entity.HelpPrint;

public interface HelpDao {
	//查询帮扶记录
	List<HelpPrint> selectHelpByUserId(int userId);

	//添加帮扶记录
	boolean insertHelp(int userId, int oldId, String helpDescription);
}
