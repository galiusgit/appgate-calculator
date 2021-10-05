package com.appgate.calc.app.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.calc.app.config.AppConfig;

/**
 * The Class DiagnosticController.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/diagnostic")
public class DiagnosticController {
	
	/** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosticController.class);

    /** The Constant UP. */
    private static final String UP = "UP";
	
	/**
	 * Health check request.
	 *
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	@GetMapping(value = "/health.check")
    @ResponseStatus(HttpStatus.OK)
    public String healthCheckRequest() throws IOException, InterruptedException {
		LOGGER.info(String.format("[%s] Health check request.", AppConfig.APP_KEY));
        return UP;
    }

}
