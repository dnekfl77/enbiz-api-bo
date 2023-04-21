package com.enbiz.api.bo.base.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import com.enbiz.api.bo.app.dto.request.login.LoginRequest;
import com.enbiz.common.base.rest.ClientInfoHolder;

public class ControllerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	String loginId = ClientInfoHolder.getClientInfo().getLoginId();
    	LoginRequest loginRequest = new LoginRequest();
    	loginRequest.setLoginId(loginId);
    	UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginRequest, "", Arrays.asList(new SimpleGrantedAuthority("ROLE_SERVICE")));
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
