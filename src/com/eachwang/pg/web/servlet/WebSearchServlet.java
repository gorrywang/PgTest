package com.eachwang.pg.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eachwang.pg.bean.OkTest;
import com.eachwang.pg.service.TestService;

/**
 * 网页搜索
 */
public class WebSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 输出
		PrintWriter writer = response.getWriter();
		// 有无cookie
		boolean b = getCook(request);
		if (!b) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		// 获取数据
		String search = request.getParameter("search");
		if ((search == null)) {
			// *****缺少参数，请重新登录
			writer.print("请返回后完整填写");
			return;
		}
		// 获取试题实体
		List<OkTest> test = null;
		try {
			test = new TestService().searchTest(search);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 输出
		request.setAttribute("test", test);
		request.getRequestDispatcher("/search.jsp").forward(request, response);

	}

	private boolean getCook(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		boolean b = false;
		for (Cookie cookie : cookies) {
			if ("username".equals(cookie.getName())) {
				b = true;
				break;
			}
		}
		return b;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
