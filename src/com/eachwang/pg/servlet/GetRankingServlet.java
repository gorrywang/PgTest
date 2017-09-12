package com.eachwang.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eachwang.pg.service.RankService;
import com.eachwang.pg.utils.Utils;
import com.google.gson.Gson;

/**
 * 获取排行榜
 * 
 * @author iswgr
 *
 */
public class GetRankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
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
		// 获取题目种类
		int m = Integer.parseInt(request.getParameter("method"));
		// 前十列表
		List rank = null;
		try {
			rank = new RankService().getRank(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// gson
		if (rank != null) {
			Gson gson = new Gson();
			String json = gson.toJson(rank);
			writer.print(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}