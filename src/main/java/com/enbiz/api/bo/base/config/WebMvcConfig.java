package com.enbiz.api.bo.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.enbiz.api.bo.base.interceptor.ControllerInterceptor;

@Configuration
@MapperScan(basePackages = "com.enbiz.api.bo.app.repository")
public class WebMvcConfig implements WebMvcConfigurer {
	@Bean
	public ControllerInterceptor controllerInterceptor() {
		return new ControllerInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(controllerInterceptor());
	}
}
