package com.eachwang.pg.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Utils {
	/**
	 * 打印日志
	 * 
	 * @param msg
	 */
	public static void logData(String msg) {
		System.out.println(msg);
	}

	/**
	 * 匹配邮箱
	 * 
	 * @param emaile
	 * @return
	 */
	public static boolean checkEmaile(String emaile) {
		String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

		Pattern p = Pattern.compile(RULE_EMAIL);

		Matcher m = p.matcher(emaile);

		return m.matches();
	}
}