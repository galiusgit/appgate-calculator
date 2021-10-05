package com.appgate.calc.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The Class SecurityConfig.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Configure.
	 *
	 * @param httpSecurity the http security
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// add security only to version path
		httpSecurity.csrf().disable()
			.antMatcher(ApiVersion.V1 + "/**")
			.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

	/**
	 * Configure global.
	 *
	 * @param authBuilder the auth builder
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.inMemoryAuthentication().withUser("admin").roles("ADMIN").password("{noop}admin");
	}
}
