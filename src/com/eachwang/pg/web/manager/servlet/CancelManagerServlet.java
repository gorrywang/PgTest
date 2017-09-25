package com.eachwang.pg.web.manager.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eachwang.pg.service.UserService;

/**
 * 取消联想一班会员
 */
public class CancelManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getMethod();
		// 注册码
		String ma = request.getParameter("cancel");
		if (!("MAQUANSHOU".equals(ma.trim().toUpperCase()))) {
			// 请输入正确的授权码
			request.setAttribute("msg", "请输入正确的授权码, 错误码: 20006");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}

		int i = 0;
		try {
			i = new UserService().cancelLenovoOneVip();
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "未查找到用户, 错误码: 20007");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		request.setAttribute("msg", "取消成功");
		request.setAttribute("result", 4);
		request.getRequestDispatcher("/msg.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
