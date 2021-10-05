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

import com.appgate.calc.domain.model.CalcStatus;

/**
 * The Class CalcSessionEntity.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(name = "calc_session", schema = "calculator")
public class CalcSessionEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4815721124962516600L;

	/** The id. */
	@Id
	private String id;
	
	@Column(name= "status", nullable = false, length = 32)
	@Enumerated(value = EnumType.STRING)
	private CalcStatus status;
	
	private BigDecimal result;
	
	/** The description. */
	private String description;
	
	/** The creation date. */
	@Column(name = "creation_date", nullable = false)
	private Date creationDate;
	
	/** The update date. */
	@Column(name = "update_date", nullable = false)
	private Date updateDate;
	
	public CalcSessionEntity() {
		super();
	}

	public CalcSessionEntity(String id, CalcStatus status, BigDecimal result, String description, Date creationDate,
			Date updateDate) {
		super();
		this.id = id;
		this.status = status;
		this.result = result;
		this.description = description;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CalcStatus getStatus() {
		return status;
	}

	public void setStatus(CalcStatus status) {
		this.status = status;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


}
