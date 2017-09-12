package com.eachwang.pg.service;

import com.eachwang.pg.dao.RankDao;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 排行榜服务
 * 
 * @author iswgr
 *
 */
public class RankService {
	/**
	 * 获取排行榜
	 * 
	 * @param method
	 *            题目中类
	 * @return 集合
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map<String, Object>> getRank(int method) throws SQLException {
		List rank = new RankDao().getRank(method);
		return rank;
	}

	/**
	 * 保存成绩
	 * 
	 * @param classify_id
	 *            题目种类
	 * @param uuid
	 *            识别码
	 * @param fraction
	 *            成绩
	 * @param username
	 *            用户名
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int saveResult(int classify_id, String uuid, Double fraction, String username) throws SQLException {
		return new RankDao().saveResult(classify_id, uuid, fraction, username);
	}
}