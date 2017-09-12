package com.eachwang.pg.service;

import com.eachwang.pg.dao.TestDao;
import java.sql.SQLException;
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
}