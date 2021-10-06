package com.appgate.calc.domain.model.operation;

import com.appgate.calc.domain.model.DefaultResponse;

/**
 * The Class OperationRes.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class OperationRes extends DefaultResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8231139228068196282L;
	
	/** The operation. */
	private Operation operation;
	
	/**
	 * Instantiates a new operation res.
	 *
	 * @param operation the operation
	 * @param code the code
	 * @param message the message
	 */
	public OperationRes(Operation operation, String code, String message) {
		super(code, message);
		this.operation = operation;
	}

	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * Sets the operation.
	 *
	 * @param operation the new operation
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
