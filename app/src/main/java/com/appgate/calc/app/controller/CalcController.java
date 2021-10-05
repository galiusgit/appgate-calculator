package com.appgate.calc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.calc.app.adapters.CalcServiceAdapter;
import com.appgate.calc.app.config.ApiVersion;
import com.appgate.calc.domain.model.CalcSessionListRes;
import com.appgate.calc.domain.model.CalcSessionRes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * The Class CalcController.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping(ApiVersion.V1 + "/calc")
@Api("Calc controller")
public class CalcController {
	
	/** The calc processor service. */
	@Autowired
	private CalcServiceAdapter calcServiceAdapter;
	
	@PostMapping()
	@ApiOperation("Return calculator session")
	@ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header", defaultValue = "Basic ")
	public ResponseEntity<CalcSessionRes> addCalcSession(@RequestBody String description) {
		var calcSessionResult = calcServiceAdapter.addCalcSession(description);
		if("OK".equals(calcSessionResult.getCode())) {
			return new ResponseEntity<CalcSessionRes>(calcSessionResult, HttpStatus.OK);
		}
		return new ResponseEntity<CalcSessionRes>(calcSessionResult, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping
	@ApiOperation("Return calc list results")
	@ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header", defaultValue = "Basic ")
	public CalcSessionListRes findAllCalcSessions() {
		return calcServiceAdapter.getAllCalcSessions();
	}
	
}
