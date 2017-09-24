package com.eachwang.pg.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eachwang.pg.bean.OkTest;
import com.eachwang.pg.bean.User;
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
		HttpSession session = request.getSession();
		ServletContext app = getServletContext();
		// 有无cookie
		String uuid = getCook(request);
		if (uuid == null || uuid.isEmpty()) {
			// 没有登录
			request.setAttribute("msg", "尊敬的用户, 请登录, 错误代码:10001");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		User user = (User) session.getAttribute(uuid);
		if (user == null) {
			// 未登录
			request.setAttribute("msg", "尊敬的用户, 请登录, 错误代码:10002");
			request.setAttribute("result", 1);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		String sessionId = (String) app.getAttribute(uuid);
		if (null == sessionId || !sessionId.equals(session.getId())) {
			/* 这说明用户已经在其他电脑或其它浏览器登录了，那么之前登录的session就无效了，自动被后面的登录给踢掉 */
			// 跳转到首页或登录页面
			request.setAttribute("msg", "您的账户在其他地点登录, 请确认是否泄露密码, 错误代码:10003");
			request.setAttribute("result", 1);
			// 刪除cookie
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				cookie.setPath(request.getContextPath()+"/");
				System.out.println(cookie.getName());
				response.addCookie(cookie);
			}
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}

		// 获取数据
		String search = request.getParameter("search");
		// 获取试题实体
		List<OkTest> test = null;
		try {
			test = new TestService().searchTest(search);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "抱歉, 服务器出现异常, 错误代码:10004");
			request.setAttribute("result", 2);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 输出
		request.setAttribute("test", test);
		request.getRequestDispatcher("/search.jsp").forward(request, response);
	}

	private String getCook(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String b = null;
		for (Cookie cookie : cookies) {
			if ("username".equals(cookie.getName())) {
				b = cookie.getValue().toString().trim();
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
