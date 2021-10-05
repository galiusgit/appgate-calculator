package com.appgate.calc.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The Class CalcSession.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcSession implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3044274037375564678L;

	/** The id. */
	private String id;
	
	private CalcStatus status;
	
	private BigDecimal result;
	
	/** The description. */
	private String description;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The update date. */
	private Date updateDate;

	public CalcSession(String id, CalcStatus status, BigDecimal result, String description, Date creationDate,
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
