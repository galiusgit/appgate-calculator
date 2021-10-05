package com.appgate.calc.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.model.CalcSession;
import com.appgate.calc.domain.model.CalcSessionListRes;
import com.appgate.calc.domain.model.CalcSessionRes;
import com.appgate.calc.domain.model.CalcStatus;
import com.appgate.calc.domain.util.DateUtil;

public class ModelTetst {

	@Test
	public void CalcSessionModel() {

		Date creationDate = DateUtil.getCurrentDate();
		Date updateDate = DateUtil.getCurrentDate();
		var result = new CalcSession("8991e126-2330-11ec-9621-0242ac130002", 
				CalcStatus.OPEN, BigDecimal.ZERO, "Some description", creationDate, updateDate);
		
		Assertions.assertEquals(result.getId(), "8991e126-2330-11ec-9621-0242ac130002");
		Assertions.assertEquals(result.getCreationDate(), creationDate);
		Assertions.assertEquals(result.getUpdateDate(), updateDate);
		Assertions.assertEquals(CalcStatus.OPEN, result.getStatus());
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
	}
	
}
