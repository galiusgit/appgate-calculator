package com.appgate.calc.domain.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.codes.AppCodes;
import com.appgate.calc.domain.codes.CalcSessionCodes;
import com.appgate.calc.domain.model.calcsession.CalcProcessReq;
import com.appgate.calc.domain.model.calcsession.CalcProcessRes;
import com.appgate.calc.domain.model.calcsession.CalcSession;
import com.appgate.calc.domain.model.calcsession.CalcSessionListRes;
import com.appgate.calc.domain.model.calcsession.CalcSessionRes;
import com.appgate.calc.domain.model.calcsession.CalcStatus;
import com.appgate.calc.domain.model.operation.Operation;
import com.appgate.calc.domain.model.operation.OperationType;
import com.appgate.calc.domain.util.DateUtil;

/**
 * The Class CalcSessionModelsTets.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcSessionModelsTets {

	/**
	 * Calc session models.
	 */
	@Test
	public void calcSessionModels() {

		Date creationDate = DateUtil.getCurrentDate();
		Date updateDate = DateUtil.getCurrentDate();
		var result = new CalcSession("8991e126-2330-11ec-9621-0242ac130002", 
				CalcStatus.PENDING_RESULT, BigDecimal.ZERO, "Some description", creationDate, updateDate);
		
		Assertions.assertEquals(result.getId(), "8991e126-2330-11ec-9621-0242ac130002");
		Assertions.assertEquals(result.getCreationDate(), creationDate);
		Assertions.assertEquals(result.getUpdateDate(), updateDate);
		Assertions.assertEquals(CalcStatus.PENDING_RESULT, result.getStatus());
		Assertions.assertEquals(BigDecimal.ZERO, result.getResult());
		Assertions.assertEquals(result.getDescription(), "Some description");
		
		CalcSessionListRes resultListRes = new CalcSessionListRes(Arrays.asList(result), "OK", "Msg test");
		Assertions.assertNotNull(resultListRes.getCalcSessionList());
		Assertions.assertTrue(resultListRes.getCalcSessionList().size() > 0);
		Assertions.assertEquals(resultListRes.getCode(), "OK");
		Assertions.assertEquals(resultListRes.getMessages(), Arrays.asList("Msg test"));
		Assertions.assertNotNull(resultListRes.getDate());
		Assertions.assertTrue(resultListRes.getFormatedMsg().contains("], msg:[Msg test]"));
		Assertions.assertTrue(resultListRes.getFormatedMsg().contains("code:[OK], date:["));
		
		CalcSessionRes resultRes = new CalcSessionRes(result, "OK", "Msg test res");
		Assertions.assertNotNull(resultRes.getCalcSession());
		Assertions.assertEquals(resultRes.getCode(), "OK");
		Assertions.assertEquals(resultRes.getMessages(), Arrays.asList("Msg test res"));
		Assertions.assertNotNull(resultRes.getDate());
		Assertions.assertTrue(resultRes.getFormatedMsg().contains("], msg:[Msg test res]"));
		Assertions.assertTrue(resultRes.getFormatedMsg().contains("code:[OK], date:["));
		
		CalcProcessReq calcProcessReq = new CalcProcessReq();
		calcProcessReq.setCalcSessionId(result.getId());
		calcProcessReq.setDescription(null);
		calcProcessReq.setOperator(ArithmeticOperator.DIVIDE);
		
		Assertions.assertNotNull(calcProcessReq.getCalcSessionId());
		Assertions.assertNull(calcProcessReq.getDescription());
		Assertions.assertNotNull(calcProcessReq.getOperator());
		
		var resultOpe = new Operation("8991e126-2330-11ec-9621-0242ac130548", calcProcessReq.getCalcSessionId(), BigDecimal.ONE, null, 
				creationDate, OperationType.RESULT, null, "test desc 1");
		
		CalcProcessRes calcProcessRes = new CalcProcessRes(result, resultOpe, AppCodes.ERROR.name(), "test process response"); 
		
		Assertions.assertNotNull(calcProcessRes.getCalcSession());
		Assertions.assertNotNull(calcProcessRes.getOperation());
		Assertions.assertEquals(calcProcessRes.getCode(), AppCodes.ERROR.name());
		Assertions.assertEquals(calcProcessRes.getMessages(), Arrays.asList("test process response"));
		Assertions.assertNotNull(calcProcessRes.getDate());
		Assertions.assertTrue(calcProcessRes.getFormatedMsg().contains("], msg:[test process response]"));
		Assertions.assertTrue(calcProcessRes.getFormatedMsg().contains("code:[ERROR], date:["));
		
		
		resultRes.setCode(CalcSessionCodes.CALC_GETTING_ERROR.name());
		Assertions.assertTrue(resultRes.getFormatedMsg().contains("code:[CALC_GETTING_ERROR], date:["));
		
		resultRes.setCode(CalcSessionCodes.CALC_UPDATE_ERROR.name());
		Assertions.assertTrue(resultRes.getFormatedMsg().contains("code:[CALC_UPDATE_ERROR], date:["));
		
		resultRes.setCode(CalcSessionCodes.CALC_GETTING_LIST_ERROR.name());
		Assertions.assertTrue(resultRes.getFormatedMsg().contains("code:[CALC_GETTING_LIST_ERROR], date:["));
		
		resultRes.setCode(CalcSessionCodes.CALC_GETTING_ERROR.name());
		Assertions.assertTrue(resultRes.getFormatedMsg().contains("code:[CALC_GETTING_ERROR], date:["));
		
		resultRes.setCode(CalcSessionCodes.CALC_SESSION_NO_RESULT.name());
		Assertions.assertTrue(resultRes.getFormatedMsg().contains("code:[CALC_SESSION_NO_RESULT], date:["));
		
		resultRes.setCode(CalcSessionCodes.CALC_SESSION_NOT_EXIST.name());
		Assertions.assertTrue(resultRes.getFormatedMsg().contains("code:[CALC_SESSION_NOT_EXIST], date:["));
		
		resultRes.setCode(CalcSessionCodes.CALC_SESSION_ID_VALIDATION.name());
		Assertions.assertTrue(resultRes.getFormatedMsg().contains("code:[CALC_SESSION_ID_VALIDATION], date:["));
		
		
	}
	
}
