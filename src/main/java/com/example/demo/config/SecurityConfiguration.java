package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
  @Override
  @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
  protected void configure(HttpSecurity http) throws Exception {
	// @formatter:off
    http
	    .authorizeRequests()
	    .antMatchers("/index.html", "/", "/home", "/login").permitAll()
	    .anyRequest().authenticated()
    .and()
    	.formLogin()
    		.and()
    	.httpBasic().disable()
    .csrf()
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        ;
      // @formatter:on
  }
}
