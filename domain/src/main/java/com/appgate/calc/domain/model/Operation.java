package com.appgate.calc.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Operation implements Serializable {

	private static final long serialVersionUID = 895963896531596885L;
	
	private String id;
	
	private String calcSessionId;
	
	private BigDecimal value;
	
	private String valueFromSessionId;
	
	private Date creationDate;
	
	private String description;

	public Operation(String id, String calcSessionId, BigDecimal value, String valueFromSessionId, Date creationDate,
			String description) {
		super();
		this.id = id;
		this.calcSessionId = calcSessionId;
		this.value = value;
		this.valueFromSessionId = valueFromSessionId;
		this.creationDate = creationDate;
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

	public String getValueFromSessionId() {
		return valueFromSessionId;
	}

	public void setValueFromSessionId(String valueFromSessionId) {
		this.valueFromSessionId = valueFromSessionId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
