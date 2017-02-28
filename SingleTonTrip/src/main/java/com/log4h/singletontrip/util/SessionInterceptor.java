package com.log4h.singletontrip.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {

			if (request.getSession().getAttribute("sessionId") == null) {
				response.sendRedirect(request.getContextPath()+"/login");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
}
