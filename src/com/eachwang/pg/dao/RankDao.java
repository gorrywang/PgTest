package com.eachwang.pg.dao;

import com.eachwang.pg.utils.DataSourceUtils;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

/**
 * 数据库操作：排行榜
 * 
 * @author iswgr
 *
 */
public class RankDao {
	/**
	 * 获取排行榜前十
	 * 
	 * @param method
	 *            题目种类
	 * @return map集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> getRank(int method) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from ranking where classify_id = ? order by fraction desc limit 10 ";
		List query = (List) runner.query(sql, new MapListHandler(), new Object[] { Integer.valueOf(method) });
		return query;
	}

	/**
	 * 保存用户成绩
	 * 
	 * @param classify_id
	 *            题目种类
	 * @param uuid
	 *            用户识别码
	 * @param fraction
	 *            成绩
	 * @param username
	 *            用户名
	 * @return int标识
	 * @throws SQLException
	 */
	public int saveResult(int classify_id, String uuid, Double fraction, String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into ranking values(null,?,?,?,null,?)";
		return runner.update(sql, new Object[] { Integer.valueOf(classify_id), uuid, fraction, username });
	}
}