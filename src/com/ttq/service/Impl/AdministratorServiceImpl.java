package com.ttq.service.Impl;

import java.util.List;

import com.ttq.dao.AdministratorDao;
import com.ttq.dao.OldDao;
import com.ttq.dao.Impl.AdministratorDaoImpl;
import com.ttq.dao.Impl.OldDaoImpl;
import com.ttq.entity.Administrator;
import com.ttq.entity.Old;
import com.ttq.entity.OldAdminPrint;
import com.ttq.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService {
	private AdministratorDao administratorDao = new AdministratorDaoImpl();
	private OldDao oldDao = new OldDaoImpl();

	@Override
	public boolean register(Administrator administrator) {
		// TODO Auto-generated method stub
		if (administratorDao.selectByAdminname(administrator.getAdminName()) != null) {
			System.out.println("用户名已存在");
			return false;
		}
		return administratorDao.insertAdmin(administrator);
	}

	@Override
	public Administrator login(String adminName, String password) {
		// TODO Auto-generated method stub
		return administratorDao.selectByAdminnameAndPassword(adminName, password);
	}

	@Override
	public boolean addOld(Old old) {
		// TODO Auto-generated method stub
		return oldDao.insertOld(old);
	}

	@Override
	public List<OldAdminPrint> showOld() {
		// TODO Auto-generated method stub
		return oldDao.seletcOld();
	}

	@Override
	public boolean deleteOld(int oldId) {
		// TODO Auto-generated method stub
		return oldDao.deleteOld(oldId);
	}

	@Override
	public boolean updateOld(int oldId, int oldAge, String address, String contact) {
		// TODO Auto-generated method stub
		return oldDao.updateOld(oldId, oldAge, address, contact);
	}

	@Override
	public Old selectOldById(int oldId) {
		// TODO Auto-generated method stub
		return oldDao.selectOldById(oldId);
	}

}
