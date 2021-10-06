package com.appgate.calc.domain.model.calcsession;

import java.io.Serializable;

import com.appgate.calc.domain.model.ArithmeticOperator;

public class CalcProcessReq implements Serializable {

	private static final long serialVersionUID = 1681859812053980251L;
	
	private String calcSessionId;
	
	private ArithmeticOperator operator;
	
	private String description;

	public CalcProcessReq() {
		super();
	}

	public String getCalcSessionId() {
		return calcSessionId;
	}

	public void setCalcSessionId(String calcSessionId) {
		this.calcSessionId = calcSessionId;
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
