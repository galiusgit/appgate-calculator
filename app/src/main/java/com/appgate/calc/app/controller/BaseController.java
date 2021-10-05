package com.appgate.calc.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class BaseController.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/")
public class BaseController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	
	/** The Constant WELLCOME_API. */
	private static final String WELLCOME_API = "Wellcome to appgate calculator API, rest service";

	/**
	 * Base path.
	 *
	 * @return the string
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping()
    public String basePath () {
		LOGGER.debug(WELLCOME_API);
		return WELLCOME_API;
	}
}
