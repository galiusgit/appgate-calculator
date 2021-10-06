package com.appgate.calc.domain.validators;

import com.appgate.calc.domain.codes.CalcSessionCodes;
import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.util.UuidUtil;

public class CalcSessionValidator {
	
	public static void validSessionId(String calcSessionId) throws AppCalcException {
		if(calcSessionId == null){
			throw new AppCalcException(CalcSessionCodes.CALC_SESSION_ID_VALIDATION.name(), "the calc session id cannot be null");
		}
		if (!UuidUtil.isUUID(calcSessionId)) {
			throw new AppCalcException(CalcSessionCodes.CALC_SESSION_ID_VALIDATION.name(), "invalid calc session id");
		}
	}

}
