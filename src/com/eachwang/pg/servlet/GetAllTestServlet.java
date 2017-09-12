package com.eachwang.pg.servlet;

import com.eachwang.pg.service.TestService;
import com.eachwang.pg.utils.Utils;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取所有试题
 * 
 * @author iswgr
 *
 */
public class GetAllTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String method = request.getMethod();
		// 输出
		PrintWriter writer = response.getWriter();
		// 禁止get
		if ("GET".equals(method.toUpperCase())) {
			Utils.logData("GET禁止登录");

			writer.print("{\"result\":\"0\",\"message\":\"禁止使用GET请求\"}");
			return;
		}
		// 试题集合
		List all = null;
		try {
			all = new TestService().getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// gson
		if (all != null) {
			Gson gson = new Gson();
			String json = gson.toJson(all);
			writer.print(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}