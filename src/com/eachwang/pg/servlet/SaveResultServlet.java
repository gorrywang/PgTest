package com.eachwang.pg.servlet;

import com.eachwang.pg.service.RankService;
import com.eachwang.pg.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 提交成绩
 * 
 * @author iswgr
 *
 */
public class SaveResultServlet extends HttpServlet {
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
		// 题目种类
		int classify_id = Integer.parseInt(request.getParameter("classify_id"));
		// 用户识别码
		String uuid = request.getParameter("uuid");
		// 成绩
		Double fraction = Double.valueOf(Double.parseDouble(request.getParameter("fraction")));
		// 用户名
		String username = request.getParameter("username");
		int i = 0;
		try {
			i = new RankService().saveResult(classify_id, uuid, fraction, username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 输出
		if (i > 0) {
			Utils.logData("成绩保存成功");
			writer.print("{\"result\":\"1\",\"message\":\"保存成功\"}");
		} else {
			Utils.logData("成绩保存失败");
			writer.print("{\"result\":\"0\",\"message\":\"保存失败\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}