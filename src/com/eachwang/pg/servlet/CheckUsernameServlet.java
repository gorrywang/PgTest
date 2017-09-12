package com.eachwang.pg.servlet;

import com.eachwang.pg.service.UserService;
import com.eachwang.pg.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 检查用户名
 * 
 * @author iswgr
 *
 */
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String method = request.getMethod();
		// 笔
		PrintWriter writer = response.getWriter();
		// 禁止get
		if ("GET".equals(method.toUpperCase())) {
			Utils.logData("GET禁止登录");

			writer.print("{\"result\":\"0\",\"message\":\"禁止使用GET请求\"}");
			return;
		}
		// 获取用户名
		String username = request.getParameter("username");
		// 检查
		boolean checkUserName = false;
		try {
			checkUserName = new UserService().checkUserName(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (checkUserName) {
			Utils.logData("用户名已存在");
			writer.print("{\"result\":\"0\",\"message\":\"用户名已存在\"}");
		} else {
			Utils.logData("用户名不存在");
			writer.print("{\"result\":\"1\",\"message\":\"用户名检查成功\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}