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

/**
 * 获取用户信息
 * 
 * @author iswgr
 *
 */
public class GetUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		// 获取uuid
		String uuid = request.getParameter("uuid");
		// 获取用户实体类
		User user = null;
		try {
			user = new UserService().getUserInfo(uuid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 输出
		if (user == null) {
			Utils.logData("获取用户数据失败，用户识别码错误");

			writer.print("{\"result\":\"0\",\"message\":\"用户识别码错误，请检查\"}");
		} else {
			Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy[] { new ExclusionStrategy() {
				public boolean shouldSkipField(FieldAttributes arg0) {
					return arg0.getName().equals("id") | arg0.getName().contains("password")
							| arg0.getName().equals("uuid");
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