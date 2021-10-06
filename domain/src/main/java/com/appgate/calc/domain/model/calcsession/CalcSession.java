package com.appgate.calc.domain.model.calcsession;

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
	
	/** The status. */
	private CalcStatus status;
	
	/** The result. */
	private BigDecimal result;
	
	/** The description. */
	private String description;
	
	/** The creation date. */
	private Date creationDate;
	
	/** The update date. */
	private Date updateDate;

	/**
	 * Instantiates a new calc session.
	 *
	 * @param id the id
	 * @param status the status
	 * @param result the result
	 * @param description the description
	 * @param creationDate the creation date
	 * @param updateDate the update date
	 */
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public CalcStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(CalcStatus status) {
		this.status = status;
	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public BigDecimal getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(BigDecimal result) {
		this.result = result;
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
	 * Gets the update date.
	 *
	 * @return the update date
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the update date.
	 *
	 * @param updateDate the new update date
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
