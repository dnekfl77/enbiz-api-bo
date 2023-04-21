package com.enbiz.api.bo.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.enbiz.common.base.token.ServiceTokenService;
import com.enbiz.common.base.token.TokenFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private ServiceTokenService tokenService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
//				.antMatchers("/", "/home", "/api/tokens").permitAll()
				.antMatchers("/error", "/samples/createToken", "/actuator/**").permitAll().anyRequest()
				.hasAnyRole("SERVICE", "ADMIN")
//				.anyRequest().authenticated()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(new TokenFilter(tokenService), UsernamePasswordAuthenticationFilter.class);
		;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/v2/api-docs", "/swagger-resources/**",
				"/swagger-ui/**", "/webjars/**");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
