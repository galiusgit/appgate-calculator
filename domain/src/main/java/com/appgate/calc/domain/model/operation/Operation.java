package com.appgate.calc.domain.model.operation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.appgate.calc.domain.model.ArithmeticOperator;

public class Operation implements Serializable {

	private static final long serialVersionUID = 895963896531596885L;
	
	private String id;
	
	private String calcSessionId;
	
	private BigDecimal value;
	
	private String fromOtherSessionId;
	
	private Date creationDate;
	
	private OperationType type; 
	
	private ArithmeticOperator operator;
	
	private String description;
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCalcSessionId() {
		return calcSessionId;
	}

	public void setCalcSessionId(String calcSessionId) {
		this.calcSessionId = calcSessionId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getFromOtherSessionId() {
		return fromOtherSessionId;
	}

	public void setFromOtherSessionId(String fromOtherSessionId) {
		this.fromOtherSessionId = fromOtherSessionId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public ArithmeticOperator getOperator() {
		return operator;
	}

	public void setOperator(ArithmeticOperator operator) {
		this.operator = operator;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
