package com.appgate.calc.domain.model.calcsession;

import java.util.List;

import com.appgate.calc.domain.model.DefaultResponse;

/**
 * The Class CalcSessionListRes.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcSessionListRes extends DefaultResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4492636744506614197L;
	
	/** The calc result list. */
	private List<CalcSession> calcSessionList;
	
	/**
	 * Instantiates a new calc session list res.
	 *
	 * @param calcSessionList the calc session list
	 * @param code the code
	 * @param message the message
	 */
	public CalcSessionListRes(List<CalcSession> calcSessionList, String code, String message) {
		super(code, message);
		this.calcSessionList = calcSessionList;
	}

	/**
	 * Gets the calc session list.
	 *
	 * @return the calc session list
	 */
	public List<CalcSession> getCalcSessionList() {
		return calcSessionList;
	}

	/**
	 * Sets the calc session list.
	 *
	 * @param calcSessionList the new calc session list
	 */
	public void setCalcSessionList(List<CalcSession> calcSessionList) {
		this.calcSessionList = calcSessionList;
	}

}
