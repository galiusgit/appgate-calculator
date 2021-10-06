package com.appgate.calc.domain.util;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The Class DateUtilTest.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class DateUtilTest {

	/**
	 * Date default format.
	 */
	@Test
	public void dateDefaultFormat() {
		String caseFormat = "2021-10-03 14:20:20";
		Date resultDate = DateUtil.msgFormatToDate("2021-10-03 14:20:20");
		Assertions.assertNotNull(resultDate);
		Assertions.assertEquals("Sun Oct 03 14:20:20 COT 2021", resultDate.toString());
		String resultDateStr = DateUtil.dateToMsgFormat(resultDate);
		Assertions.assertNotNull(resultDateStr);
		Assertions.assertEquals(caseFormat, resultDateStr);
	}

}
