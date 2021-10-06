package com.appgate.calc.domain.model.operation;

import java.io.Serializable;
import java.math.BigDecimal;

public class OperationReq implements Serializable {
	
	private static final long serialVersionUID = -3368928407749172330L;

	private String calcSessionId;
	
	private BigDecimal value;
	
	private String description;

	public OperationReq() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
