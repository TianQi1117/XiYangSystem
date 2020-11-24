package com.ttq.dao.Impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ttq.dao.AdministratorDao;
import com.ttq.entity.Administrator;
import com.ttq.util.JDBCUtil;

public class AdministratorDaoImpl implements AdministratorDao {

	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public Administrator selectByAdminname(String adminname) {
		// TODO Auto-generated method stub
		String sql = "select * from tb_administrator where adminName=?";
		List<Administrator> adminList = template.query(sql,
				new BeanPropertyRowMapper<Administrator>(Administrator.class), adminname);
		if (adminList == null || adminList.size() == 0) {
			return null;
		}
		return adminList.get(0);
	}

	@Override
	public boolean insertAdmin(Administrator administrator) {
		String sql = "insert into tb_administrator values(null,?,?,?)";
		return template.update(sql, administrator.getAdminName(), administrator.getPassword(),
				administrator.getAddTime()) > 0 ? true : false;

	}

	@Override
	public Administrator selectByAdminnameAndPassword(String adminname, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from tb_administrator where adminName=? and password=?";
		List<Administrator> adminList = template.query(sql,
				new BeanPropertyRowMapper<Administrator>(Administrator.class), adminname, password);
		if (adminList == null || adminList.size() == 0) {
			return null;
		}
		return adminList.get(0);
	}

}
