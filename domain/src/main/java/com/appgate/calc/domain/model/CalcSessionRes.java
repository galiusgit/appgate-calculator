package com.appgate.calc.domain.model;

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
	
	private CalcSession calcSession;

	public CalcSessionRes(CalcSession calcSession, String code, String message) {
		super(code, message);
		this.calcSession = calcSession;
	}

	public CalcSession getCalcSession() {
		return calcSession;
	}

	public void setCalcSession(CalcSession calcSession) {
		this.calcSession = calcSession;
	}

}
