package com.appgate.calc.infra.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.appgate.calc.domain.model.ArithmeticOperator;
import com.appgate.calc.domain.model.OperationType;

@Entity
@Table(name = "operation", schema = "calculator")
public class OperationEntity implements Serializable {
	
	private static final long serialVersionUID = -1593933589637059617L;

	@Id
	private String id;
	
	@Column(name = "calc_session_id", nullable = false)
	private String calcSessionId;
	
	@Column(name = "value", nullable = false)
	private BigDecimal value;
	
	@Column(name = "other_session_id")
	private String fromOtherSessionId;
	
	@Column(name = "creation_date", nullable = false)
	private Date creationDate;
	
	@Column(name= "type", nullable = false, length = 32)
	@Enumerated(value = EnumType.STRING)
	private OperationType type; 
	
	private ArithmeticOperator operator;
	
	private String description;

	public OperationEntity() {
		super();
	}

	public OperationEntity(String id, String calcSessionId, BigDecimal value, String fromOtherSessionId, Date creationDate,
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
