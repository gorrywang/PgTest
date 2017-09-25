package com.eachwang.pg.web.manager.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eachwang.pg.service.UserService;

/**
 * 恢复购买者会员
 */
public class ReSetManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getMethod();
		// 注册码
		String ma = request.getParameter("reset");
		if (!("MAFUHUI".equals(ma.trim().toUpperCase()))) {
			// 请输入正确的授权码
			request.setAttribute("msg", "请输入正确的恢复码, 错误码: 20008");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}

		int i = 0;
		try {
			i = new UserService().resetVip();
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "未查找到用户, 错误码: 20009");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		request.setAttribute("msg", "恢复成功");
		request.setAttribute("result", 4);
		request.getRequestDispatcher("/msg.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
