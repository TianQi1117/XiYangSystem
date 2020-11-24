package com.ttq.dao;

import java.util.List;

import com.ttq.entity.Old;
import com.ttq.entity.OldAdminPrint;
import com.ttq.entity.OldNoHelp;
import com.ttq.entity.OldUserHelpPrint;

public interface OldDao {
	//添加老人
	boolean insertOld(Old old);

	//更新老人
	boolean updateOld(int oldId, int oldAge, String address, String contact);

	//删除老人
	boolean deleteOld(int oldId);

	//查询老人
	List<OldAdminPrint> seletcOld();

	//帮扶老人
	boolean updateHelpOld(int oldId, int userId);

	//查询未被帮扶的老人
	List<OldNoHelp> selectNoHelpOld();

	//查询某人帮扶的老人列表
	List<OldUserHelpPrint> selectOldByUserId(int userId);

	//查询某个老人信息
	Old selectOldById(int oldId);
}
