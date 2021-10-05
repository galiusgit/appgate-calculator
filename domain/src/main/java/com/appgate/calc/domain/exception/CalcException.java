package com.appgate.calc.domain.exception;

import java.util.Date;

import com.appgate.calc.domain.util.DateUtil;

/**
 * The Class CalcException.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1173414613917382287L;
	
	/** The Constant FORMAT_MSG. */
	private static final String FORMAT_MSG = "%s - %s";
	
	/** The code. */
	private String code;
	
	/** The date. */
	private Date date;

	/**
	 * Instantiates a new calc calc exception.
	 *
	 * @param code the code
	 * @param errorMessage the error message
	 */
	public CalcException(String code, String errorMessage) {
	    super(String.format(FORMAT_MSG, code, errorMessage));
	    this.code = code;
	    this.date = DateUtil.getCurrentDate();
	}
	
	/**
	 * Instantiates a new calc calc exception.
	 *
	 * @param code the code
	 * @param errorMessage the error message
	 * @param cause the cause
	 */
	public CalcException(String code, String errorMessage, Throwable cause) {
	    super(String.format(FORMAT_MSG, code, errorMessage), cause);
	    this.code = code;
	    this.date = DateUtil.getCurrentDate();
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Gets the formated msg.
	 *
	 * @return the formated msg
	 */
	public String getFormatedMsg() {
		return String.format(FORMAT_MSG, DateUtil.dateToMsgFormat(this.date), getMessage());
	}
	
}
