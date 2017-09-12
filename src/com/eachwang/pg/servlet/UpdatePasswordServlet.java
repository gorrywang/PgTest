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
 * 修改密码
 * 
 * @author iswgr
 *
 */
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String method = request.getMethod();
		PrintWriter writer = response.getWriter();
		if ("GET".equals(method.toUpperCase())) {
			Utils.logData("GET禁止登录");

			writer.print("{\"result\":\"0\",\"message\":\"禁止使用GET请求\"}");
			return;
		}
		// 获取数据
		String o = request.getParameter("old");
		String n = request.getParameter("new");
		String uuid = request.getParameter("uuid");
		int i = 0;
		try {
			i = new UserService().updatePassword(o, n, uuid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 输出
		if (i > 0) {
			Utils.logData("密码修改成功");
			writer.print("{\"result\":\"1\",\"message\":\"密码修改成功\"}");
		} else if (i == -1) {
			Utils.logData("旧密码错误");
			writer.print("{\"result\":\"-1\",\"message\":\"旧密码错误\"}");
		} else {
			Utils.logData("未知错误");
			writer.print("{\"result\":\"0\",\"message\":\"错误，请重试\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}