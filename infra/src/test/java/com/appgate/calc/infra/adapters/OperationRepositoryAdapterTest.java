package com.appgate.calc.infra.adapters;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.operation.Operation;
import com.appgate.calc.domain.model.operation.OperationType;
import com.appgate.calc.domain.ports.OperationRepositoryPort;
import com.appgate.calc.domain.util.DateUtil;

@SpringBootTest(classes={com.appgate.calc.infra.init.AppInfraTest.class})
public class OperationRepositoryAdapterTest {
	
	private static final String OPERATION_ID = "e171daac-261b-11ec-9621-0242ac130002";
	
	private static final String CALC_SESSION_ID = "6258109e-261e-11ec-9621-0242ac130002";
	
	private static final String DESCRIPTION = "operation test description 1";
	
	private Date creationDate = DateUtil.getCurrentDate();
	
	@Autowired
	private OperationRepositoryPort opeRepo;
	
	@Test
	public void createCalcSession() throws AppCalcException {
		var toCreate = new Operation(OPERATION_ID, CALC_SESSION_ID, BigDecimal.ONE, null, 
				creationDate, OperationType.RESULT, null, DESCRIPTION);
		
		var result = opeRepo.createOperation(toCreate);
		
		Assertions.assertTrue(result.isPresent());
		Assertions.assertEquals(OPERATION_ID, result.get().getId());
		Assertions.assertEquals(CALC_SESSION_ID, result.get().getCalcSessionId());
		Assertions.assertEquals(BigDecimal.ONE, result.get().getValue());
		Assertions.assertNull(result.get().getFromOtherSessionId());
		Assertions.assertNotNull(result.get().getCreationDate());
		Assertions.assertEquals(OperationType.RESULT, result.get().getType());
		Assertions.assertNull(result.get().getOperator());
		Assertions.assertEquals(DESCRIPTION, result.get().getDescription());
	}
	
	@Test
	public void findBySessionId() throws AppCalcException {
		var resultList = opeRepo.findBySessionId(CALC_SESSION_ID);
		
		Assertions.assertNotNull(resultList);
		Assertions.assertTrue(resultList.size() > 0);
		
		var result = resultList.get(0);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(OPERATION_ID, result.getId());
		Assertions.assertEquals(CALC_SESSION_ID, result.getCalcSessionId());
		Assertions.assertEquals(BigDecimal.ONE, result.getValue());
		Assertions.assertNull(result.getFromOtherSessionId());
		Assertions.assertNotNull(result.getCreationDate());
		Assertions.assertEquals(OperationType.RESULT, result.getType());
		Assertions.assertNull(result.getOperator());
		Assertions.assertEquals(DESCRIPTION, result.getDescription());
	}
	
	@Test
	public void findBySessionIdAndDate() throws AppCalcException {
		var resultList = opeRepo.findBySessionIdAndDate(CALC_SESSION_ID, creationDate);
		
		Assertions.assertNotNull(resultList);
		Assertions.assertTrue(resultList.size() == 0);
	}
	
	@Test
	public void getLastResult() throws AppCalcException {
		var result = opeRepo.getLastResult(CALC_SESSION_ID);
		
		Assertions.assertTrue(result.isPresent());
		Assertions.assertEquals(OPERATION_ID, result.get().getId());
		Assertions.assertEquals(CALC_SESSION_ID, result.get().getCalcSessionId());
		Assertions.assertEquals(BigDecimal.ONE, result.get().getValue());
		Assertions.assertNull(result.get().getFromOtherSessionId());
		Assertions.assertNotNull(result.get().getCreationDate());
		Assertions.assertEquals(OperationType.RESULT, result.get().getType());
		Assertions.assertNull(result.get().getOperator());
		Assertions.assertEquals(DESCRIPTION, result.get().getDescription());
	}

}
