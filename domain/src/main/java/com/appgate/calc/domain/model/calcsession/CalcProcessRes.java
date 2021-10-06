package com.appgate.calc.domain.model.calcsession;

import com.appgate.calc.domain.model.DefaultResponse;
import com.appgate.calc.domain.model.operation.Operation;

public class CalcProcessRes extends DefaultResponse {

	private static final long serialVersionUID = -7301215860801651171L;
	
	private CalcSession calcSession;
	
	private Operation operation;
	
	public CalcProcessRes(CalcSession calcSession, Operation operation, String code, String message) {
		super(code, message);
		this.calcSession = calcSession;
		this.operation = operation;
	}

	public CalcSession getCalcSession() {
		return calcSession;
	}

	public void setCalcSession(CalcSession calcSession) {
		this.calcSession = calcSession;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
