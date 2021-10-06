package com.appgate.calc.domain.model.operation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.appgate.calc.domain.model.ArithmeticOperator;

/**
 * The Class Operation.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class Operation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 895963896531596885L;
	
	/** The id. */
	private String id;
	
	/** The calc session id. */
	private String calcSessionId;
	
	/** The value. */
	private BigDecimal value;
	
	/** The from other session id. */
	private String fromOtherSessionId;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The type. */
	private OperationType type; 
	
	/** The operator. */
	private ArithmeticOperator operator;
	
	/** The description. */
	private String description;
	
	/**
	 * Instantiates a new operation.
	 *
	 * @param id the id
	 * @param calcSessionId the calc session id
	 * @param value the value
	 * @param fromOtherSessionId the from other session id
	 * @param creationDate the creation date
	 * @param type the type
	 * @param operator the operator
	 * @param description the description
	 */
	public Operation(String id, String calcSessionId, BigDecimal value, 
			String fromOtherSessionId, Date creationDate,
			OperationType type, ArithmeticOperator operator, String description) {
		super();
		this.id = id;
		this.calcSessionId = calcSessionId;
		this.value = value;
		this.fromOtherSessionId = fromOtherSessionId;
		this.creationDate = creationDate;
		this.type = type;
		this.operator = operator;
		this.description = description;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
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
	 * Gets the from other session id.
	 *
	 * @return the from other session id
	 */
	public String getFromOtherSessionId() {
		return fromOtherSessionId;
	}

	/**
	 * Sets the from other session id.
	 *
	 * @param fromOtherSessionId the new from other session id
	 */
	public void setFromOtherSessionId(String fromOtherSessionId) {
		this.fromOtherSessionId = fromOtherSessionId;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public OperationType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(OperationType type) {
		this.type = type;
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
