package com.eachwang.pg.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		ServletContext app = getServletContext();
		// 获取数据
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		if ((password == null) || (username == null) || username == "" || password == "") {
			// *****缺少参数，请重新登录
			// response.sendRedirect();
			request.setAttribute("msg", "请填写完整登录信息, 错误代码:10005");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 获取用户实体
		User user = null;
		try {
			user = new UserService().login(username, MD5Utils.MD5(password));
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "抱歉, 服务器出现异常, 请稍后再试, 错误代码:10006");
			request.setAttribute("result", 2);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 输出
		if (user == null) {
			// ******用户不存在
			request.setAttribute("msg", "用户名或密码错误, 请检查, 错误代码:10007");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} else {
			// ******登录成功
			int vip = user.getVip();
			if (vip == 1) {
				// 单点登录
				session.setAttribute(user.getUuid(),user);
				app.setAttribute(user.getUuid(), session.getId());
				Cookie cookie = new Cookie("username", user.getUuid());
				// cookie.setMaxAge(60 * 60 * 4);
				cookie.setPath(request.getContextPath() + "/");
				response.addCookie(cookie);
				request.setAttribute("msg", user.getUsername() + ": 尊敬的会员, 恭喜登录成功");
				request.setAttribute("result", 3);
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
//				 response.sendRedirect(request.getContextPath() + "/index.jsp");
			} else {
				request.setAttribute("msg", user.getUsername() + ": 您不是会员, 禁止使用会员服务, 错误代码:10008");
				request.setAttribute("result", 2);
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
