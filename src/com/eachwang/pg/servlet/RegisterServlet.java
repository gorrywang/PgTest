package com.eachwang.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eachwang.pg.bean.User;
import com.eachwang.pg.service.UserService;
import com.eachwang.pg.utils.UUIDUtils;
import com.eachwang.pg.utils.Utils;

/**
 * 注册
 * 
 * @author iswgr
 *
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getMethod();
		PrintWriter writer = response.getWriter();
		if ("GET".equals(method.toUpperCase())) {
			Utils.logData("GET禁止注册");

			writer.print("{\"result\":\"0\",\"message\":\"禁止使用GET请求\"}");
			return;
		}
		// 用户名
		String username = request.getParameter("username");
		// 密码
		String password = request.getParameter("password");
		// 性别
		int sex = Integer.parseInt(request.getParameter("sex"));
		// 电子邮箱
		String email = request.getParameter("email");
		// 邮箱是否验证
		int emailvalidate = Integer.parseInt(request.getParameter("emailvalidate"));
		// 班级
		String cla = request.getParameter("cla");
		// 识别码
		String uuid = UUIDUtils.getUUID();
		// 是否是vip
		int vip = 0;
		// 个性签名
		String autograph = "";
		// 封装User
		User user = new User(uuid, username, password, sex, cla, email, emailvalidate, vip, autograph);
		System.out.println(user.toString());
		int data = 0;
		try {
			data = new UserService().register(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (data == -1) {
			Utils.logData("用户名已存在");
			writer.print("{\"result\":\"-1\",\"message\":\"用户名已存在\"}");
		} else if (data == 0) {
			Utils.logData("邮箱已存在");
			writer.print("{\"result\":\"-2\",\"message\":\"邮箱已存在\"}");
		} else {
			Utils.logData("注册成功");
			writer.print("{\"result\":\"1\",\"message\":\"注册成功\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}