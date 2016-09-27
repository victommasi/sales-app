package com.victommasi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Value("${loginUserJ}")
	private String loginJ;
	
	@Value("${loginUserV}")
	private String loginV;
	
	@Value("${passwordUserJ}")
	private String passJ;
	
	@Value("${passwordUserV}")
	private String passV;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.antMatchers("/layout/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest()
				.authenticated()
			.and() 
				.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
			    .logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser(loginJ).password(passJ)
				.roles("")
			.and()
				.withUser(loginV).password(passV)
				.roles("");
	} 
	
}
