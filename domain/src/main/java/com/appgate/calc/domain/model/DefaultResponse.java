package com.appgate.calc.domain.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.appgate.calc.domain.util.DateUtil;

/**
 * The Class DefaultResponse.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class DefaultResponse implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8758667378490389734L;

	/** The Constant DEFAULT_OK. */
	public static final DefaultResponse DEFAULT_OK = new DefaultResponse("OK", "[DEFAULT_OK] success response");
	
	/** The Constant DEFAULT_ERROR. */
	public static final DefaultResponse DEFAULT_ERROR = new DefaultResponse("ERROR", "[DEFAULT_ERROR] error response");
	
	/** The code. */
	private String code;
	
	/** The messages. */
	private List<String> messages;
	
	/** The date. */
	private Date date;

	/**
	 * Instantiates a new default response.
	 */
	public DefaultResponse() {
		super();
	}

	/**
	 * Instantiates a new default response.
	 *
	 * @param code the code
	 * @param messages the messages
	 */
	public DefaultResponse(String code, List<String> messages) {
		super();
		this.code = code;
		this.messages = messages;
		this.date = DateUtil.getCurrentDate();
	}
	
	/**
	 * Instantiates a new default response.
	 *
	 * @param code the code
	 * @param message the message
	 */
	public DefaultResponse(String code, String message) {
		super();
		this.code = code;
		this.messages = Arrays.asList(message);
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
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * Sets the messages.
	 *
	 * @param messages the new messages
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
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
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Gets the formated msg.
	 *
	 * @return the formated msg
	 */
	@JsonIgnore
	public String getFormatedMsg() {
		if (this.messages != null) {
			return String.format("code:[%s], date:[%s], msg:[%s]", this.code, 
					DateUtil.dateToMsgFormat(this.date), 
					String.join(", ", this.messages));
		}
		return String.format("code:[%s], date:[%s], msg:[]", this.code, 
				DateUtil.dateToMsgFormat(this.date));
	}

}
