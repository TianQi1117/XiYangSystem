package com.ttq.service.Impl;

import java.util.List;

import com.ttq.dao.HelpDao;
import com.ttq.dao.OldDao;
import com.ttq.dao.UserDao;
import com.ttq.dao.Impl.HelpDaoImpl;
import com.ttq.dao.Impl.OldDaoImpl;
import com.ttq.dao.Impl.UserDaoImpl;
import com.ttq.entity.HelpPrint;
import com.ttq.entity.OldNoHelp;
import com.ttq.entity.OldUserHelpPrint;
import com.ttq.entity.User;
import com.ttq.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	private OldDao oldDao = new OldDaoImpl();
	private HelpDao helpdao = new HelpDaoImpl();

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.selectByUsernameAndPassword(username, password);
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		if (userDao.selectByUsername(user.getUserName()) != null) {
			System.out.println("用户名已存在");
			return false;
		}
		return userDao.insertUser(user);
	}

	@Override
	public List<OldNoHelp> showNeedHelpOld() {
		// TODO Auto-generated method stub
		return oldDao.selectNoHelpOld();
	}

	@Override
	public boolean addHelpOld(int oldId, int userId) {
		// TODO Auto-generated method stub
		return oldDao.updateHelpOld(oldId, userId);
	}

	@Override
	public boolean addHelp(int userId, int oldId, String helpDescription) {
		// TODO Auto-generated method stub
		return helpdao.insertHelp(userId, oldId, helpDescription);
	}

	@Override
	public List<HelpPrint> showHelp(int userId) {
		// TODO Auto-generated method stub
		return helpdao.selectHelpByUserId(userId);
	}

	@Override
	public List<OldUserHelpPrint> selectOldByUserId(int userId) {
		// TODO Auto-generated method stub
		return oldDao.selectOldByUserId(userId);
	}

}
