package com.appgate.calc.domain.model.operation;

import com.appgate.calc.domain.model.DefaultResponse;
import com.appgate.calc.domain.model.calcsession.CalcSession;

/**
 * The Class NewOperationRes.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class NewOperationRes extends DefaultResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3870091727082484931L;
	
	/** The calc session. */
	private CalcSession calcSession;
	
	/** The operation. */
	private Operation operation;
	
	/**
	 * Instantiates a new new operation res.
	 *
	 * @param calcSession the calc session
	 * @param operation the operation
	 * @param code the code
	 * @param message the message
	 */
	public NewOperationRes(CalcSession calcSession, Operation operation, String code, String message) {
		super(code, message);
		this.calcSession = calcSession;
		this.operation = operation;
	}

	/**
	 * Gets the calc session.
	 *
	 * @return the calc session
	 */
	public CalcSession getCalcSession() {
		return calcSession;
	}

	/**
	 * Sets the calc session.
	 *
	 * @param calcSession the new calc session
	 */
	public void setCalcSession(CalcSession calcSession) {
		this.calcSession = calcSession;
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
