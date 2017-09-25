package com.eachwang.pg.dao;

import com.eachwang.pg.bean.User;
import com.eachwang.pg.utils.DataSourceUtils;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDao {
	/**
	 * 邮箱登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户实体类
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User loginByEmail(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where password = ? and email = ?";
		return (User) runner.query(sql, new BeanHandler(User.class), new Object[] { password, username });
	}

	/**
	 * 用户名登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户实体类
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User loginByUserName(String username, String password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where password = ? and username = ?";
		return (User) runner.query(sql, new BeanHandler(User.class), new Object[] { password, username });
	}

	/**
	 * 检查用户名是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return 用户实体
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User checkUserName(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ?";
		return (User) runner.query(sql, new BeanHandler(User.class), new Object[] { username });
	}

	/**
	 * 检查邮箱是否存在
	 * 
	 * @param email
	 *            电子邮箱
	 * @return 用户实体类
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public User checkEmail(String email) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where email = ?";
		return (User) runner.query(sql, new BeanHandler(User.class), new Object[] { email });
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户实体类
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int register(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
		return runner.update(sql, new Object[] { null, user.getUuid(), user.getUsername(), user.getPassword(),
				Integer.valueOf(user.getSex()), user.getCla(), user.getEmail(),
				Integer.valueOf(user.getEmailvalidate()), Integer.valueOf(user.getVip()), user.getAutograph(), null });
	}

	/**
	 * 获取用户信息
	 * 
	 * @param uuid
	 *            识别码
	 * @return 用户实体
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User getUserInfo(String uuid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where uuid = ?";
		return (User) runner.query(sql, new BeanHandler(User.class), new Object[] { uuid });
	}

	/**
	 * 更新个人信息
	 * 
	 * @param uuid
	 *            识别码吗
	 * @param sex
	 *            性别
	 * @param cla
	 *            班级
	 * @param autograph
	 *            个性签名
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int updateUserInfo(String uuid, int sex, String cla, String autograph) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set sex = ? , cla = ? , autograph = ? where uuid = ?";
		return runner.update(sql, new Object[] { Integer.valueOf(sex), cla, autograph, uuid });
	}

	/**
	 * 检查旧密码是否正确
	 * 
	 * @param uuid
	 *            用户识别码
	 * @param o
	 *            旧密码
	 * @return 用户实体类
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User checkOld(String uuid, String o) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where password = ? and uuid = ?";
		return (User) runner.query(sql, new BeanHandler(User.class), new Object[] { o, uuid });
	}

	/**
	 * 修改密码
	 * 
	 * @param n
	 *            新密码
	 * @param uuid
	 *            用户识别码
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int updatePassword(String n, String uuid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set password = ? where uuid = ?";
		return runner.update(sql, new Object[] { n, uuid });
	}

	/**
	 * 充值VIP
	 * 
	 * @param email
	 *            电子邮箱
	 * @return
	 * @throws SQLException
	 */
	public int vip(String email) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set vip = 1 where email = ?";
		return runner.update(sql, email);
	}

	/**
	 * 取消联想一班会员
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int cancelLenovoOneVip() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set vip = 0 where cla like ?";
		return runner.update(sql, "%联想一班%");
	}

	/**
	 * 恢复购买者会员
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int resetVip() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set vip = 1 where cla like ?";
		return runner.update(sql, "%购买%");
	}
}