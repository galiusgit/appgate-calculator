package com.appgate.calc.infra.adapters;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.CalcSession;
import com.appgate.calc.domain.model.CalcStatus;
import com.appgate.calc.domain.ports.CalcSessionRepositoryPort;
import com.appgate.calc.domain.util.DateUtil;

@SpringBootTest(classes={com.appgate.calc.infra.init.AppInfraTest.class})
public class CalcSessionRepositoryAdapterTest {
	
	private static final String CALC_SESSION_ID = "8991e126-2330-11ec-9621-0242ac130002";
	
	@Autowired
	private CalcSessionRepositoryPort calcRepo;
	
	@Test
	void createCalcSession() throws AppCalcException {
		Date creationDate = DateUtil.getCurrentDate();
		Date updateDate = DateUtil.getCurrentDate();
		
		Optional<CalcSession> result = calcRepo.createCalcSession(new CalcSession(CALC_SESSION_ID, 
				CalcStatus.HAS_RESULT, BigDecimal.ZERO, "Test description", creationDate, updateDate));
		
		Assertions.assertTrue(result.isPresent());
		Assertions.assertEquals(result.get().getId(), CALC_SESSION_ID);
		Assertions.assertEquals(result.get().getCreationDate(), creationDate);
		Assertions.assertEquals(result.get().getUpdateDate(), updateDate);
		Assertions.assertEquals(CalcStatus.HAS_RESULT, result.get().getStatus());
		Assertions.assertEquals(BigDecimal.ZERO, result.get().getResult());
		Assertions.assertEquals(result.get().getDescription(), "Test description");
	}
	
	@Test
	void findAllCalcSessions() throws AppCalcException{
		List<CalcSession> listResult =  calcRepo.findAllCalcSessions();
		Assertions.assertNotNull(listResult);
		Assertions.assertTrue(listResult.size() > 0);
	}
	
	@Test
	public void getById() throws AppCalcException {
		var result = calcRepo.getById(CALC_SESSION_ID);
		Assertions.assertTrue(result.isPresent());
		Assertions.assertTrue(result.isPresent());
		Assertions.assertEquals(result.get().getId(), CALC_SESSION_ID);
		Assertions.assertNotNull(result.get().getCreationDate());
		Assertions.assertNotNull(result.get().getUpdateDate());
		Assertions.assertEquals(CalcStatus.HAS_RESULT, result.get().getStatus());
		Assertions.assertEquals(BigDecimal.ZERO, result.get().getResult());
		Assertions.assertEquals(result.get().getDescription(), "Test description");
	}

}
