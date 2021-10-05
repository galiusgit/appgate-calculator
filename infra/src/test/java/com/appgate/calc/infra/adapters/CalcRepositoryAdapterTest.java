package com.appgate.calc.infra.adapters;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appgate.calc.domain.exception.CalcException;
import com.appgate.calc.domain.model.CalcSession;
import com.appgate.calc.domain.model.CalcStatus;
import com.appgate.calc.domain.util.DateUtil;

@SpringBootTest(classes={com.appgate.calc.infra.init.AppInfraTest.class})
public class CalcRepositoryAdapterTest {
	
	@Autowired
	private CalcRepositoryAdapter calcRepositoryAdapter;
	
	@Test
	void createCalcSession() throws CalcException {
		Date creationDate = DateUtil.getCurrentDate();
		Date updateDate = DateUtil.getCurrentDate();
		
		Optional<CalcSession> result = calcRepositoryAdapter.createCalcSession(new CalcSession("8991e126-2330-11ec-9621-0242ac130002", 
				CalcStatus.OPEN, BigDecimal.ZERO, "Some description", creationDate, updateDate));
		
		Assertions.assertTrue(result.isPresent());
		Assertions.assertEquals(result.get().getId(), "8991e126-2330-11ec-9621-0242ac130002");
		Assertions.assertEquals(result.get().getCreationDate(), creationDate);
		Assertions.assertEquals(result.get().getUpdateDate(), updateDate);
		Assertions.assertEquals(CalcStatus.OPEN, result.get().getStatus());
		Assertions.assertEquals(result.get().getDescription(), "Some description");
	}
	
	@Test
	void findAllCalcSessions() throws CalcException{
		List<CalcSession> listResult =  calcRepositoryAdapter.findAllCalcSessions();
		Assertions.assertNotNull(listResult);
		Assertions.assertTrue(listResult.size() > 0);
	}

}
