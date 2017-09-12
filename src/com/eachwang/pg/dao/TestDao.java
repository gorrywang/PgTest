package com.eachwang.pg.dao;

import com.eachwang.pg.utils.DataSourceUtils;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

/**
 * 试题数据库操作
 * 
 * @author iswgr
 *
 */
public class TestDao {
	/**
	 * 获取所有题目
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getAll() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from question";
		List list = (List) runner.query(sql, new MapListHandler());
		return list;
	}

	/**
	 * 随机获取题目
	 * 
	 * @param num
	 *            题目数量
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getRandomTest(int num) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from question ORDER BY rand() LIMIT ?";
		List list = (List) runner.query(sql, new MapListHandler(), new Object[] { Integer.valueOf(num) });
		return list;
	}
}