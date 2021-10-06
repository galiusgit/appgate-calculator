package com.appgate.calc.domain.validators;

import com.appgate.calc.domain.codes.CalcSessionCodes;
import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.util.UuidUtil;

/**
 * The Class CalcSessionValidator.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcSessionValidator {
	
	/**
	 * Valid session id.
	 *
	 * @param calcSessionId the calc session id
	 * @throws AppCalcException the app calc exception
	 */
	public static void validSessionId(String calcSessionId) throws AppCalcException {
		if(calcSessionId == null){
			throw new AppCalcException(CalcSessionCodes.CALC_SESSION_ID_VALIDATION.name(), "the calc session id cannot be null");
		}
		if (!UuidUtil.isUUID(calcSessionId)) {
			throw new AppCalcException(CalcSessionCodes.CALC_SESSION_ID_VALIDATION.name(), "invalid calc session id");
		}
	}

}
