package com.ttq.dao.Impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ttq.dao.OldDao;
import com.ttq.entity.Old;
import com.ttq.entity.OldAdminPrint;
import com.ttq.entity.OldNoHelp;
import com.ttq.entity.OldUserHelpPrint;
import com.ttq.util.JDBCUtil;

public class OldDaoImpl implements OldDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public boolean insertOld(Old old) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_old values(null,?,now(),?,?,?,?,null)";
		return template.update(sql, old.getOldName(), old.getOldSex(), old.getOldAge(), old.getAddress(),
				old.getContact()) > 0 ? true : false;
	}

	@Override
	public boolean updateOld(int oldId, int oldAge, String address, String contact) {
		// TODO Auto-generated method stub
		String sql = "update tb_old set oldAge=?,address=?,contact=? where oldId=?";
		return template.update(sql, oldAge, address, contact, oldId) > 0 ? true : false;
	}

	@Override
	public boolean deleteOld(int oldId) {
		// TODO Auto-generated method stub
		String sql = "delete from tb_old where oldId=?";
		return template.update(sql, oldId) > 0 ? true : false;
	}

	@Override
	public List<OldAdminPrint> seletcOld() {
		// TODO Auto-generated method stub
		String sql = "select oldName,oldAge,oldSex,address,contact from tb_old";
		List<OldAdminPrint> oldList = template.query(sql,
				new BeanPropertyRowMapper<OldAdminPrint>(OldAdminPrint.class));
		return oldList;
	}

	@Override
	public List<OldUserHelpPrint> selectOldByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql = "select oldId,oldName from tb_old where userId=?";
		List<OldUserHelpPrint> oldList = template.query(sql,
				new BeanPropertyRowMapper<OldUserHelpPrint>(OldUserHelpPrint.class), userId);
		return oldList;
	}

	@Override
	public List<OldNoHelp> selectNoHelpOld() {
		// TODO Auto-generated method stub
		String sql = "select oldName,oldAge,oldSex,address,contact from tb_old where userId is null ";
		List<OldNoHelp> oldList = template.query(sql, new BeanPropertyRowMapper<OldNoHelp>(OldNoHelp.class));
		return oldList;
	}

	@Override
	public boolean updateHelpOld(int oldId, int userId) {
		// TODO Auto-generated method stub
		String sql = "update tb_old set userId=? where oldId=?";
		return template.update(sql, userId, oldId) > 0 ? true : false;
	}

	@Override
	public Old selectOldById(int oldId) {
		// TODO Auto-generated method stub
		String sql = "select * from tb_old where oldId=?";
		List<Old> oldList = template.query(sql, new BeanPropertyRowMapper<Old>(Old.class), oldId);
		return oldList.get(0);
	}
}
