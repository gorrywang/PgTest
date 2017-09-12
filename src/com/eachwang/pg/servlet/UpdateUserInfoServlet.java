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
 * 修改个人信息
 * 
 * @author iswgr
 *
 */
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getMethod();
		PrintWriter writer = response.getWriter();
		if ("GET".equals(method.toUpperCase())) {
			Utils.logData("GET禁止申请接口");

			writer.print("{\"result\":\"0\",\"message\":\"禁止使用GET请求\"}");
			return;
		}
		// 获取数据
		String uuid = request.getParameter("uuid");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String cla = request.getParameter("cla");
		String autograph = request.getParameter("autograph");
		// service
		int update = 0;
		try {
			update = new UserService().updateUserInfo(uuid, sex, cla, autograph);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 输出
		if (update > 0) {
			Utils.logData("用户修改个人信息成功");
			writer.print("{\"result\":\"1\",\"message\":\"修改成功\"}");
		} else {
			Utils.logData("用户修改个人信息失败");
			writer.print("{\"result\":\"0\",\"message\":\"修改失败 \"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}