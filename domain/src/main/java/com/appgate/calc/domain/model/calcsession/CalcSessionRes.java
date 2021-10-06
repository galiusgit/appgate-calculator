package com.appgate.calc.domain.model.calcsession;

import com.appgate.calc.domain.model.DefaultResponse;

/**
 * The Class CalcSessionRes.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcSessionRes extends DefaultResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5521188284738299488L;
	
	/** The calc session. */
	private CalcSession calcSession;

	/**
	 * Instantiates a new calc session res.
	 *
	 * @param calcSession the calc session
	 * @param code the code
	 * @param message the message
	 */
	public CalcSessionRes(CalcSession calcSession, String code, String message) {
		super(code, message);
		this.calcSession = calcSession;
	}

	/**
	 * Gets the calc session.
	 *
	 * @return the calc session
	 */
	public CalcSession getCalcSession() {
		return calcSession;
	}

	/**
	 * Sets the calc session.
	 *
	 * @param calcSession the new calc session
	 */
	public void setCalcSession(CalcSession calcSession) {
		this.calcSession = calcSession;
	}

}
