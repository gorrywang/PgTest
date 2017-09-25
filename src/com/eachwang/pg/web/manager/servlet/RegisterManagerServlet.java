package com.eachwang.pg.web.manager.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eachwang.pg.bean.User;
import com.eachwang.pg.service.UserService;
import com.eachwang.pg.utils.MD5Utils;
import com.eachwang.pg.utils.UUIDUtils;
import com.eachwang.pg.utils.Utils;

/**
 * 注册管理员
 */
public class RegisterManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getMethod();
		// 注册码
		String ma = request.getParameter("reg");
		if (!("MACEZHU".equals(ma.trim().toUpperCase()))) {
			// 请输入正确的注册码
			request.setAttribute("msg", "请输入正确的注册码, 错误码: 20001");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		// 用户名
		String username = request.getParameter("username");
		// 密码
		String password = request.getParameter("password");
		// 电子邮箱
		String email = request.getParameter("email");
		// 班级
		String cla = request.getParameter("cla");
		// 识别码
		String uuid = UUIDUtils.getUUID();
		// 是否是vip
		int vip = 0;
		// 个性签名
		String autograph = "";
		// 封装User
		User user = new User(uuid, username, MD5Utils.MD5(password), 1, cla, email, 1, vip, autograph);
		System.out.println(user.toString());
		int data = 0;
		try {
			data = new UserService().register(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (data == -1) {
			Utils.logData("用户名已存在");
			request.setAttribute("msg", "用户名已存在, 错误码: 20002");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} else if (data == 0) {
			Utils.logData("邮箱已存在");
			request.setAttribute("msg", "邮箱已存在, 错误码: 20003");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} else {
			Utils.logData("注册成功");
			request.setAttribute("msg", "注册成功");
			request.setAttribute("result", 4);
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
