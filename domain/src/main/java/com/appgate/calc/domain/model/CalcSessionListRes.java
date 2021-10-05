package com.appgate.calc.domain.model;

import java.util.List;

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
	
	public CalcSessionListRes(List<CalcSession> calcSessionList, String code, String message) {
		super(code, message);
		this.calcSessionList = calcSessionList;
	}

	public List<CalcSession> getCalcSessionList() {
		return calcSessionList;
	}

	public void setCalcSessionList(List<CalcSession> calcSessionList) {
		this.calcSessionList = calcSessionList;
	}

}
