package com.fhk.sample.web.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@ConditionalOnWebApplication
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Override
	protected void configure(final HttpSecurity http) throws Exception 
	{
		http.authorizeRequests().anyRequest().permitAll()
		.and().csrf().disable();
	}

	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.inMemoryAuthentication().withUser("admin").password("admin")
				.roles("ADMIN", "USER").and().withUser("user").password("user")
				.roles("USER");
	}


}
