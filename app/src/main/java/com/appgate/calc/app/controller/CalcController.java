package com.appgate.calc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.calc.app.adapters.CalcServiceAdapter;
import com.appgate.calc.app.config.ApiVersion;
import com.appgate.calc.domain.codes.AppCodes;
import com.appgate.calc.domain.model.calcsession.CalcProcessReq;
import com.appgate.calc.domain.model.calcsession.CalcProcessRes;
import com.appgate.calc.domain.model.calcsession.CalcSessionListRes;
import com.appgate.calc.domain.model.calcsession.CalcSessionRes;
import com.appgate.calc.domain.model.operation.NewOperationRes;
import com.appgate.calc.domain.model.operation.OperationReq;
import com.appgate.calc.domain.model.operation.OperationRes;

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
@RequestMapping(ApiVersion.V1 + "/calculator")
@Api("Calc controller")
public class CalcController {
	
	/** The calculator processor service. */
	@Autowired
	private CalcServiceAdapter calcServiceAdapter;
	
	/**
	 * Adds the calculator session.
	 *
	 * @param description the description
	 * @return the response entity
	 */
	@PostMapping()
	@ApiOperation("Create and return a calculator session")
	@ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header", defaultValue = "Basic ")
	public ResponseEntity<CalcSessionRes> addCalcSession(@RequestBody String description) {
		var calcSessionResult = calcServiceAdapter.addCalcSession(description);
		if(AppCodes.OK.name().equals(calcSessionResult.getCode())) {
			return new ResponseEntity<>(calcSessionResult, HttpStatus.OK);
		}
		return new ResponseEntity<>(calcSessionResult, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Adds the operation to session.
	 *
	 * @param operationReq the operation request
	 * @return the response entity
	 */
	@PostMapping("/add-operation")
	@ApiOperation("Add new operation to calculator session")
	@ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header", defaultValue = "Basic ")
	public ResponseEntity<NewOperationRes> addOperationToSession(@RequestBody OperationReq operationReq) {
		var newOperationRes = calcServiceAdapter.addOperationToSession(operationReq);
		if(AppCodes.OK.name().equals(newOperationRes.getCode())) {
			return new ResponseEntity<>(newOperationRes, HttpStatus.OK);
		}
		return new ResponseEntity<>(newOperationRes, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Builds the calc session process.
	 *
	 * @param calcProcessReq the calc process req
	 * @return the response entity
	 */
	@PostMapping("/build-calc")
	@ApiOperation("Build calculator process for session id")
	@ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header", defaultValue = "Basic ")
	public ResponseEntity<CalcProcessRes> buildCalcSessionProcess(@RequestBody CalcProcessReq calcProcessReq) {
		var calcResult = calcServiceAdapter.buildCalcSessionProcess(calcProcessReq);
		if(AppCodes.OK.name().equals(calcResult.getCode())) {
			return new ResponseEntity<>(calcResult, HttpStatus.OK);
		}
		return new ResponseEntity<>(calcResult, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Gets the last result.
	 *
	 * @param calcSessionId the calculator session id
	 * @return the last result
	 */
	@GetMapping("/{calcSessionId}")
	@ApiOperation("Gets the last result for calc session id")
	@ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header", defaultValue = "Basic ")
	public ResponseEntity<OperationRes> getLastResult(@PathVariable("calcSessionId") String calcSessionId) {
		var calcSessionList = calcServiceAdapter.getLastResult(calcSessionId);
		if(AppCodes.OK.name().equals(calcSessionList.getCode())) {
			return new ResponseEntity<>(calcSessionList, HttpStatus.OK);
		}
		return new ResponseEntity<>(calcSessionList, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Find all calculator sessions.
	 *
	 * @return the response entity
	 */
	@GetMapping
	@ApiOperation("Gets the calculator session list")
	@ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header", defaultValue = "Basic ")
	public ResponseEntity<CalcSessionListRes> findAllCalcSessions() {
		var calcSessionList = calcServiceAdapter.getAllCalcSessions();
		if(AppCodes.OK.name().equals(calcSessionList.getCode())) {
			return new ResponseEntity<>(calcSessionList, HttpStatus.OK);
		}
		return new ResponseEntity<>(calcSessionList, HttpStatus.BAD_REQUEST);
	}
	
}
