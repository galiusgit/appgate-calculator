package com.appgate.calc.domain.model.operation;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The Class OperationReq.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class OperationReq implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3368928407749172330L;

	/** The calc session id. */
	private String calcSessionId;
	
	/** The value. */
	private BigDecimal value;
	
	/** The description. */
	private String description;

	/**
	 * Instantiates a new operation req.
	 */
	public OperationReq() {
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
	 * Gets the value.
	 *
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
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
