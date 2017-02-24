package com.log4h.singletontrip.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExampleInterceptor extends HandlerInterceptorAdapter{
    
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      /*  try {
            //sessionId이라는 세션key를 가진 정보가 null일경우 로그인페이지로 이동
            if(request.getSession().getAttribute("sessionId") == null ){
                    response.sendRedirect("index");
                    return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
    	//세션key 존재시 main 페이지 이동
        return true;
    }
}
