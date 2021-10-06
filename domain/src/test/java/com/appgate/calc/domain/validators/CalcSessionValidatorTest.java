package com.appgate.calc.domain.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.codes.CalcSessionCodes;
import com.appgate.calc.domain.exception.AppCalcException;

/**
 * The Class CalcSessionValidatorTest.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcSessionValidatorTest {
	
	/**
	 * Valid session id.
	 *
	 * @throws AppCalcException the app calc exception
	 */
	@Test
	public void validSessionId() throws AppCalcException {
		AppCalcException exception1 = Assertions.assertThrows(AppCalcException.class, () -> {
			CalcSessionValidator.validSessionId(null);
		});
		Assertions.assertTrue(exception1.getMessage().contains("the calc session id cannot be null"));
		Assertions.assertEquals(CalcSessionCodes.CALC_SESSION_ID_VALIDATION.name(), exception1.getCode());
		//---
		AppCalcException exception2 = Assertions.assertThrows(AppCalcException.class, () -> {
			CalcSessionValidator.validSessionId("kasjdhqwekjsadn");
		});
		Assertions.assertTrue(exception2.getMessage().contains("invalid calc session id"));
		Assertions.assertEquals(CalcSessionCodes.CALC_SESSION_ID_VALIDATION.name(), exception2.getCode());
	}

}
