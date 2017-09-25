package com.eachwang.pg.web.manager.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eachwang.pg.service.UserService;

/**
 * 充值vip
 */
public class VipManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getMethod();
		// 注册码
		String ma = request.getParameter("vip");
		if (!("MAZHICHONG".equals(ma.trim().toUpperCase()))) {
			// 请输入正确的注册码
			request.setAttribute("msg", "请输入正确的充值码, 错误码: 20004");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 电子邮箱
		String email = request.getParameter("email");
		int i = 0;
		try {
			i = new UserService().vip(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i == 1) {
			request.setAttribute("msg", "充值成功");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "未找到用户, 错误码: 20005");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
