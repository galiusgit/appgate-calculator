package com.appgate.calc.domain.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The Class UuidUtilTest.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class UuidUtilTest {
	
	/**
	 * Basic cases.
	 */
	@Test
	public void basicCases() {
		Assertions.assertTrue(UuidUtil.isUUID("7a27ccea-2679-11ec-9621-0242ac130002"));
		Assertions.assertTrue(UuidUtil.isUUID("7a27ccea-2679-11ec-9621-0262ac130865"));
		Assertions.assertFalse(UuidUtil.isUUID(""));
		Assertions.assertFalse(UuidUtil.isUUID(null));
		Assertions.assertFalse(UuidUtil.isUUID("sdkfjslkdfwqoiuyhksd3529038udsa"));
		var result = UuidUtil.newUuid();
		Assertions.assertNotNull(result);
		Assertions.assertTrue(UuidUtil.isUUID(result));
	}

}
