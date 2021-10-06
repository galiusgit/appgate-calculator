package com.appgate.calc.domain.validators;

import com.appgate.calc.domain.codes.OperationCodes;
import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.operation.OperationReq;
import com.appgate.calc.domain.util.UuidUtil;

/**
 * The Class OperationValidator.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class OperationValidator {
	
	/**
	 * Valid operation req.
	 *
	 * @param operationReq the operation req
	 * @throws AppCalcException the app calc exception
	 */
	public static void validOperationReq(OperationReq operationReq) throws AppCalcException {
		if (operationReq == null) {
			throw new AppCalcException(OperationCodes.OPE_REQ_VALIDATION.name(), "operation request cannot be null");
		}
		if (operationReq.getCalcSessionId() == null || !UuidUtil.isUUID(operationReq.getCalcSessionId())) {
			throw new AppCalcException(OperationCodes.OPE_REQ_VALIDATION.name(), "invalid calc session id");
		}
		if (operationReq.getValue() == null) {
			throw new AppCalcException(OperationCodes.OPE_REQ_VALIDATION.name(), "the value cannot be null");
		}
	}

}
