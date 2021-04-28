package com.dz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginuser = request.getSession().getAttribute("loginuser");
        if (loginuser==null){
            request.setAttribute("msg","没有权限，请先登录");
            //转发
            request.getRequestDispatcher("/toLogin").forward(request,response);
            return false;
        }
        else
            return true;
    }
}
