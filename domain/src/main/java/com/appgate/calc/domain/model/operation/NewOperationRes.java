package com.appgate.calc.domain.model.operation;

import com.appgate.calc.domain.model.DefaultResponse;
import com.appgate.calc.domain.model.calcsession.CalcSession;

public class NewOperationRes extends DefaultResponse {

	private static final long serialVersionUID = 3870091727082484931L;
	
	private CalcSession calcSession;
	
	private Operation operation;
	
	public NewOperationRes(CalcSession calcSession, Operation operation, String code, String message) {
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
