package com.eachwang.pg.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eachwang.pg.bean.User;
import com.eachwang.pg.service.UserService;
import com.eachwang.pg.utils.MD5Utils;

/**
 * 网页登录
 */
public class WebLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 输出
		PrintWriter writer = response.getWriter();
		// 获取数据
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		if ((password == null) || (username == null)) {
			// *****缺少参数，请重新登录
			// response.sendRedirect();
			writer.print("请返回后完整填写");
			return;
		}
		// 获取用户实体
		User user = null;
		try {
			user = new UserService().login(username, MD5Utils.MD5(password));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 输出
		if (user == null) {
			// ******用户不存在
			writer.print("用户不存在，请返回后完整填写");
		} else {
			// ******登录成功
			int vip = user.getVip();
			if (vip == 1) {
				Cookie cookie = new Cookie("username", user.getUsername());
				cookie.setMaxAge(60 * 60 * 4);
				cookie.setPath(request.getContextPath() + "/");
				response.addCookie(cookie);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			} else {
				writer.print("该用户不是会员，禁止使用会员服务");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
