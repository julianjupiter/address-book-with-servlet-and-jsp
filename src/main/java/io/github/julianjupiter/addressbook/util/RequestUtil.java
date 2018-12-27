package io.github.julianjupiter.addressbook.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
	
	private RequestUtil() {}
	
	public static String path(HttpServletRequest request) {
		return request.getRequestURI().substring(request.getContextPath().length());
	}
	
	public static String input(HttpServletRequest request, String param) {
		boolean paramExists = request.getParameterMap().containsKey(param);
		if (paramExists) {
			return request.getParameter(param);
		}		
		
		return "";
	}
}
