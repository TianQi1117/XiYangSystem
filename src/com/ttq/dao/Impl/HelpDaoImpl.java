package com.ttq.dao.Impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ttq.dao.HelpDao;
import com.ttq.entity.HelpPrint;
import com.ttq.util.JDBCUtil;

public class HelpDaoImpl implements HelpDao {

	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public List<HelpPrint> selectHelpByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql = "select o.oldName,h.helpDescription,h.addTime from tb_help h left join tb_old o on h.oldId=o.oldId where h.userId=?";
		List<HelpPrint> helpList = template.query(sql, new BeanPropertyRowMapper<HelpPrint>(HelpPrint.class), userId);
		return helpList;
	}

	@Override
	public boolean insertHelp(int userId, int oldId, String helpDescription) {
		// TODO Auto-generated method stub

		String sql = "insert into tb_help values(null,?,?,now(),?)";

		return template.update(sql, oldId, userId, helpDescription) > 0 ? true : false;
	}

}
