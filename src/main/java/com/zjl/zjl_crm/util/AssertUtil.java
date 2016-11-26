package com.zjl.zjl_crm.util;

import org.apache.commons.lang3.StringUtils;

import com.zjl.zjl_base.exception.ParamException;


public class AssertUtil {
	
	/**
	 * 判断对象不能为空
	 * @param obj
	 * @param message
	 */
	public static void notNull(Object obj, String... message) {
		if (obj == null) {
			String msg = buildMsg(message);
			throw new ParamException(msg);
		}
	}
	
	/**
	 * 判断字符串不能为空
	 * @param str
	 * @param message
	 */
	public static void notEmpty(String str, String... message) {
		if (StringUtils.isBlank(str)) {
			String msg = buildMsg(message);
			throw new ParamException(msg);
		}
	}
	
	public static void isTrue(boolean isTrue, String... message) {
		if (isTrue) {
			String msg = buildMsg(message);
			throw new ParamException(msg);
		}
	}
	
	/**
	 * 构建打印消息
	 * @param message
	 * @return
	 */
	private static String buildMsg (String[] message) {
		String msg = "";
		if (message == null || message.length < 1) {
			msg = "参数不能为空";
		} else {
			msg = message[0];
		}
		return msg;
	}
	
}
