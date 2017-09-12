package com.eachwang.pg.utils;

import java.util.UUID;

/**
 * 用戶唯一识别码
 * 
 * @author iswgr
 *
 */
public abstract class UUIDUtils {
	/**
	 * 获取识别码
	 * 
	 * @return 识别码
	 */
	public static final String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "").toUpperCase();
	}
}