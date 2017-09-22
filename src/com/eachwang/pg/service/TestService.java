package com.eachwang.pg.service;

import com.eachwang.pg.bean.OkTest;
import com.eachwang.pg.bean.Test;
import com.eachwang.pg.dao.TestDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 试题服务
 * 
 * @author iswgr
 *
 */
public class TestService {
	/**
	 * 获取所有试题
	 * 
	 * @return map集合
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map<String, Object>> getAll() throws SQLException {
		List all = new TestDao().getAll();
		return all;
	}

	/**
	 * 随机获取题目
	 * 
	 * @param num
	 *            题目数量
	 * @return 集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getRandomTest(int num) throws SQLException {
		return new TestDao().getRandomTest(num);
	}

	/**
	 * 搜索试题
	 * 
	 * @param search
	 *            搜索试题
	 * @return
	 * @throws SQLException
	 */
	public List<OkTest> searchTest(String search) throws SQLException {
		List<Test> test = new TestDao().searchTest(search);
		List<OkTest> okT = new ArrayList<>();
		OkTest okTest = null;
		for (Test t : test) {
			okTest = new OkTest();
			// 设置问题
			okTest.setQuestion(t.getQuestion());

			String answer = t.getAnswer();
			String ok = null;
			if (answer.equals("A")) {
				ok = t.getQa();
			} else if (answer.equals("B")) {
				ok = t.getQb();
			} else if (answer.equals("C")) {
				ok = t.getQc();
			} else if (answer.equals("D")) {
				ok = t.getQd();
			}
			// 设置答案
			okTest.setOk(ok);
			// 设置到
			okT.add(okTest);
			okTest = null;
		}
		return okT;
	}
}