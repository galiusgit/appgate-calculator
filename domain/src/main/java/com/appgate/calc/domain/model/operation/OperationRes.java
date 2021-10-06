package com.appgate.calc.domain.model.operation;

import com.appgate.calc.domain.model.DefaultResponse;

public class OperationRes extends DefaultResponse {

	private static final long serialVersionUID = -8231139228068196282L;
	
	private Operation operation;
	
	public OperationRes(Operation operation, String code, String message) {
		super(code, message);
		this.operation = operation;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
