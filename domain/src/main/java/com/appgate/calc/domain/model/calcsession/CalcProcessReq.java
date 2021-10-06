package com.appgate.calc.domain.model.calcsession;

import java.io.Serializable;

import com.appgate.calc.domain.model.ArithmeticOperator;

/**
 * The Class CalcProcessReq.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcProcessReq implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1681859812053980251L;
	
	/** The calc session id. */
	private String calcSessionId;
	
	/** The operator. */
	private ArithmeticOperator operator;
	
	/** The description. */
	private String description;

	/**
	 * Instantiates a new calc process req.
	 */
	public CalcProcessReq() {
		super();
	}

	/**
	 * Gets the calc session id.
	 *
	 * @return the calc session id
	 */
	public String getCalcSessionId() {
		return calcSessionId;
	}

	/**
	 * Sets the calc session id.
	 *
	 * @param calcSessionId the new calc session id
	 */
	public void setCalcSessionId(String calcSessionId) {
		this.calcSessionId = calcSessionId;
	}

	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public ArithmeticOperator getOperator() {
		return operator;
	}

	/**
	 * Sets the operator.
	 *
	 * @param operator the new operator
	 */
	public void setOperator(ArithmeticOperator operator) {
		this.operator = operator;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
