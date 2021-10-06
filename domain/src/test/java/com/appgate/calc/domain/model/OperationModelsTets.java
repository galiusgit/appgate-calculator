package com.appgate.calc.domain.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.codes.AppCodes;
import com.appgate.calc.domain.codes.OperationCodes;
import com.appgate.calc.domain.model.calcsession.CalcSession;
import com.appgate.calc.domain.model.calcsession.CalcStatus;
import com.appgate.calc.domain.model.operation.NewOperationRes;
import com.appgate.calc.domain.model.operation.Operation;
import com.appgate.calc.domain.model.operation.OperationReq;
import com.appgate.calc.domain.model.operation.OperationRes;
import com.appgate.calc.domain.model.operation.OperationType;
import com.appgate.calc.domain.util.DateUtil;
import com.appgate.calc.domain.util.UuidUtil;

/**
 * The Class OperationModelsTets.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class OperationModelsTets {
	
/** The Constant OPERATION_ID. */
private static final String OPERATION_ID = "e171daac-261b-11ec-9621-0242ac130002";
	
	/** The Constant CALC_SESSION_ID. */
	private static final String CALC_SESSION_ID = "6258109e-261e-11ec-9621-0242ac130002";
	
	/** The Constant DESCRIPTION. */
	private static final String DESCRIPTION = "operation test description 1";
	
	/**
	 * Operation models.
	 */
	@Test
	public void operationModels() {
		var creationDate = DateUtil.getCurrentDate();
		
		var result = new Operation(OPERATION_ID, CALC_SESSION_ID, BigDecimal.ONE, null, 
				creationDate, OperationType.RESULT, null, DESCRIPTION);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(OPERATION_ID, result.getId());
		Assertions.assertEquals(CALC_SESSION_ID, result.getCalcSessionId());
		Assertions.assertEquals(BigDecimal.ONE, result.getValue());
		Assertions.assertNull(result.getFromOtherSessionId());
		Assertions.assertNotNull(result.getCreationDate());
		Assertions.assertEquals(OperationType.RESULT, result.getType());
		Assertions.assertNull(result.getOperator());
		Assertions.assertEquals(DESCRIPTION, result.getDescription());
		
		var opeRes = new OperationRes(result, AppCodes.OK.name(), "message test operation response");
		
		Assertions.assertNotNull(opeRes.getOperation());
		Assertions.assertEquals(opeRes.getCode(), "OK");
		Assertions.assertEquals(opeRes.getMessages(), Arrays.asList("message test operation response"));
		Assertions.assertNotNull(opeRes.getDate());
		Assertions.assertTrue(opeRes.getFormatedMsg().contains("], msg:[message test operation response]"));
		Assertions.assertTrue(opeRes.getFormatedMsg().contains("code:[OK], date:["));
		
		opeRes.setCode(OperationCodes.OPE_SAVE_ERROR.name());
		Assertions.assertTrue(opeRes.getFormatedMsg().contains("code:[OPE_SAVE_ERROR], date:["));
		opeRes.setCode(OperationCodes.OPE_GET_LIST_BY_CALC_SESSION_ERROR.name());
		Assertions.assertTrue(opeRes.getFormatedMsg().contains("code:[OPE_GET_LIST_BY_CALC_SESSION_ERROR], date:["));
		opeRes.setCode(OperationCodes.OPE_GETTING_ERROR.name());
		Assertions.assertTrue(opeRes.getFormatedMsg().contains("code:[OPE_GETTING_ERROR], date:["));
		opeRes.setCode(OperationCodes.OPE_REQ_VALIDATION.name());
		Assertions.assertTrue(opeRes.getFormatedMsg().contains("code:[OPE_REQ_VALIDATION], date:["));
		opeRes.setCode(OperationCodes.OPE_GET_BY_CALC_SESSION_ERROR.name());
		Assertions.assertTrue(opeRes.getFormatedMsg().contains("code:[OPE_GET_BY_CALC_SESSION_ERROR], date:["));
		
		Date updateDate = DateUtil.getCurrentDate();
		var calcSession = new CalcSession("8991e126-2330-11ec-9621-0242ac130002", 
				CalcStatus.PENDING_RESULT, BigDecimal.ZERO, "Some description", creationDate, updateDate);
		
		var newOpe = new NewOperationRes(calcSession, result, AppCodes.OK.name(), "message test new operation response");
		
		Assertions.assertNotNull(newOpe.getOperation());
		Assertions.assertNotNull(newOpe.getCalcSession());
		Assertions.assertEquals(newOpe.getCode(), "OK");Assertions.assertEquals(opeRes.getCode(), "OK");
		Assertions.assertEquals(newOpe.getMessages(), Arrays.asList("message test new operation response"));
		Assertions.assertNotNull(newOpe.getDate());
		Assertions.assertTrue(newOpe.getFormatedMsg().contains("], msg:[message test new operation response]"));
		Assertions.assertTrue(newOpe.getFormatedMsg().contains("code:[OK], date:["));
		
		var opeReq = new OperationReq();
		
		opeReq.setCalcSessionId(CALC_SESSION_ID);
		opeReq.setValue(BigDecimal.ONE);
		opeReq.setDescription("test desc");
		
		Assertions.assertTrue(UuidUtil.isUUID(opeReq.getCalcSessionId()));
		Assertions.assertEquals(BigDecimal.ONE, opeReq.getValue());
		Assertions.assertEquals("test desc", opeReq.getDescription());
	}

}
