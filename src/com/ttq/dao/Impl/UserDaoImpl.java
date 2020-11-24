package com.ttq.dao.Impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ttq.dao.UserDao;
import com.ttq.entity.User;
import com.ttq.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from tb_user where userName=?";
		List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class), username);
		if (userList == null || userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_user values(null,?,?,?,?,?,?)";
		return template.update(sql, user.getName(), user.getUserName(), user.getPassword(), user.getSex(),
				user.getAge(), user.getPhone()) > 0 ? true : false;
	}

	@Override
	public User selectByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from tb_user where userName=? and password=?";
		List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
		if (userList == null || userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

}
