package com.eachwang.pg.service;

import com.eachwang.pg.bean.User;
import com.eachwang.pg.dao.UserDao;
import com.eachwang.pg.utils.Utils;
import java.sql.SQLException;

/**
 * 用户服务
 * 
 * @author iswgr
 *
 */
public class UserService {
	/**
	 * 用户登录
	 * 
	 * @param username
	 *            用户名或邮箱
	 * @param password
	 *            密码
	 * @return 用户实体
	 * @throws SQLException
	 */
	public User login(String username, String password) throws SQLException {
		User user = null;
		if (Utils.checkEmaile(username)) {
			Utils.logData("邮箱形式登录");

			user = new UserDao().loginByEmail(username, password);
		} else {
			Utils.logData("用户名形式登录");

			user = new UserDao().loginByUserName(username, password);
		}
		return user;
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
		boolean userBool = checkUserName(user.getUsername());

		boolean emailBool = checkEmail(user.getEmail());
		if (userBool) {
			return -1;
		}
		if (emailBool) {
			return 0;
		}

		return new UserDao().register(user);
	}

	/**
	 * 
	 * 检查邮箱是否存在
	 * 
	 * @param email
	 *            邮箱
	 * @return bool
	 * @throws SQLException
	 */
	public boolean checkEmail(String email) throws SQLException {
		User user = new UserDao().checkEmail(email);
		boolean isbool = true;
		if (user == null) {
			isbool = false;
		}
		return isbool;
	}

	/**
	 * 检查用户名是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return bool
	 * @throws SQLException
	 */
	public boolean checkUserName(String username) throws SQLException {
		User checkUserName = new UserDao().checkUserName(username);
		boolean isbool = true;
		if (checkUserName == null) {
			isbool = false;
		}
		return isbool;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param uuid
	 *            识别码
	 * @return 用户实体类
	 * @throws SQLException
	 */
	public User getUserInfo(String uuid) throws SQLException {
		return new UserDao().getUserInfo(uuid);
	}

	/**
	 * 更新用户数据
	 * 
	 * @param uuid
	 *            识别码
	 * @param sex
	 *            性别
	 * @param cla
	 *            班级
	 * @param autograph
	 *            个签
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int updateUserInfo(String uuid, int sex, String cla, String autograph) throws SQLException {
		return new UserDao().updateUserInfo(uuid, sex, cla, autograph);
	}

	/**
	 * 修改密码
	 * 
	 * @param o
	 *            旧密码
	 * @param n
	 *            新密码
	 * @param uuid
	 *            识别码
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int updatePassword(String o, String n, String uuid) throws SQLException {
		User checkOld = checkOld(uuid, o);
		if (checkOld == null) {
			return -1;
		}

		return new UserDao().updatePassword(n, uuid);
	}

	/**
	 * 检查旧米密码
	 * 
	 * @param uuid
	 *            识别码
	 * @param o
	 *            就密码
	 * @return 用户实体类
	 * @throws SQLException
	 */
	private User checkOld(String uuid, String o) throws SQLException {
		return new UserDao().checkOld(uuid, o);
	}
}