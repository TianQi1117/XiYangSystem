package com.ttq.test;

import org.junit.Test;

import com.ttq.dao.HelpDao;
import com.ttq.dao.Impl.HelpDaoImpl;

public class HelpTest {
	private HelpDao helpDao = new HelpDaoImpl();

	@Test
	public void test1() {
		System.out.println(helpDao.selectHelpByUserId(1));
	}
}
