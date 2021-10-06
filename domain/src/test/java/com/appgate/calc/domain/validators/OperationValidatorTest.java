package com.appgate.calc.domain.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.codes.OperationCodes;
import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.operation.OperationReq;

/**
 * The Class OperationValidatorTest.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class OperationValidatorTest {
	
	/**
	 * Valid operation req.
	 */
	@Test
	public void validOperationReq() {
		AppCalcException exception1 = Assertions.assertThrows(AppCalcException.class, () -> {
			OperationValidator.validOperationReq(null);
		});
		Assertions.assertTrue(exception1.getMessage().contains("operation request cannot be null"));
		Assertions.assertEquals(OperationCodes.OPE_REQ_VALIDATION.name(), exception1.getCode());
		//----
		AppCalcException exception2 = Assertions.assertThrows(AppCalcException.class, () -> {
			var opeReq = new OperationReq();
			opeReq.setCalcSessionId(null);
			opeReq.setDescription("desc test");
			opeReq.setValue(null);
			OperationValidator.validOperationReq(opeReq);
		});
		Assertions.assertTrue(exception2.getMessage().contains("invalid calc session id"));
		Assertions.assertEquals(OperationCodes.OPE_REQ_VALIDATION.name(), exception2.getCode());
		//----
		AppCalcException exception3 = Assertions.assertThrows(AppCalcException.class, () -> {
			var opeReq = new OperationReq();
			opeReq.setCalcSessionId("9d9f0dc8-2679-11ec-9621-0242ac130002");
			opeReq.setDescription("desc test");
			opeReq.setValue(null);
			OperationValidator.validOperationReq(opeReq);
		});
		Assertions.assertTrue(exception3.getMessage().contains("the value cannot be null"));
		Assertions.assertEquals(OperationCodes.OPE_REQ_VALIDATION.name(), exception3.getCode());
	}

}
