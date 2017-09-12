package com.eachwang.pg.servlet;

import com.eachwang.pg.bean.User;
import com.eachwang.pg.service.UserService;
import com.eachwang.pg.utils.Utils;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		// 获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ((password == null) || (username == null)) {
			Utils.logData("缺少参数");
			writer.print("{\"result\":\"0\",\"message\":\"缺少参数\"}");
			return;
		}
		// 获取用户实体
		User user = null;
		try {
			user = new UserService().login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 输出
		if (user == null) {
			Utils.logData("用户不存在");
			writer.print("{\"result\":\"0\",\"message\":\"用户不存在 \"}");
		} else {
			Utils.logData("用户存在");
			Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy[] { new ExclusionStrategy() {
				public boolean shouldSkipField(FieldAttributes arg0) {
					return arg0.getName().equals("id") | arg0.getName().contains("password");
				}

				public boolean shouldSkipClass(Class<?> arg0) {
					return false;
				}
			} }).create();
			String json = gson.toJson(user);
			writer.print(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}