package com.appgate.calc.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The Class AppConfig.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

	/** The rate limit interceptor. */
	@Autowired
	private RateLimitInterceptor rateLimitInterceptor;

	/**
	 * Adds the interceptors.
	 *
	 * @param registry the registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LOGGER.info("----> init rateLimitInterceptor");
		registry.addInterceptor(rateLimitInterceptor).addPathPatterns(ApiVersion.V1 + "/**");
	}
}
