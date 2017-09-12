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
 * 检查邮箱
 * 
 * @author iswgr
 *
 */
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String method = request.getMethod();
		// 笔
		PrintWriter writer = response.getWriter();
		// get禁止使用
		if ("GET".equals(method.toUpperCase())) {
			Utils.logData("GET禁止登录");

			writer.print("{\"result\":\"0\",\"message\":\"禁止使用GET请求\"}");
			return;
		}
		// 获取邮箱
		String email = request.getParameter("email");
		// 检查邮箱
		boolean checkEmail = false;
		try {
			checkEmail = new UserService().checkEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (checkEmail) {
			Utils.logData("邮箱已存在");

			writer.print("{\"result\":\"0\",\"message\":\"邮箱已存在\"}");
		} else {
			Utils.logData("邮箱不存在");

			writer.print("{\"result\":\"1\",\"message\":\"邮箱检查成功\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}