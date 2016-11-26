package com.zjl.zjl_crm.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class CookieUtil {

	/**
	 * 设置Cookie
	 * @param key Cookie名称
	 * @param value Cookie Value
	 * @param domain
	 * @param response
	 */
	public static void setCookie(String key, String value, String domain,
			HttpServletResponse response) {

		try {
			value = URLEncoder.encode(value, "UTF-8");
			if (StringUtils.isNotBlank(value)) {
                value = value.replaceAll("\\+", "%20"); // 这是因为空格encode后它会变成+ 而+号前端decode解析的时候解析不出来所以替换成%20（这是前端encode的结果）
			}
			Cookie cookie = new Cookie(key, value);
			cookie.setMaxAge(-1);
			cookie.setPath("/");
			cookie.setDomain(domain);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置Cookie
	 * @param key Cookie名称
	 * @param value Cookie Value
	 * @param domain
	 * @param response
	 */
	public static void setCookieNoEncode(String key, String value, String domain,
			HttpServletResponse response) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}

	/**
	 * 获取Cookie
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(key)) {
					cookie = cookies[i];
				}
			}
		}
		if (cookie != null) {
			try {
				return URLDecoder.decode(cookie.getValue(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 清除cookie
	 * @param cookieName
	 * @param request
	 * @param response
	 */
	public static void deleteCookie(String cookieName, HttpServletRequest request, 
			HttpServletResponse response) {
		Cookie[] arr_cookie = request.getCookies();
		if (arr_cookie != null && arr_cookie.length > 0) {
			for (Cookie cookie : arr_cookie) {
				if (cookie.getName().equals(cookieName)) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		}
	}
}
