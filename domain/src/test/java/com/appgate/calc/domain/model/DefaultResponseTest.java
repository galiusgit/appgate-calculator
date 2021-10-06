package com.appgate.calc.domain.model;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The Class DefaultResponseTest.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class DefaultResponseTest {

	/**
	 * Case 1.
	 */
	@Test
	public void case1() {
		DefaultResponse df = new DefaultResponse("CODE", "message test");
		Assertions.assertNotNull(df.getDate());
		Assertions.assertEquals("CODE", df.getCode());
		List<String> expectedList = Arrays.asList("message test");
		Assertions.assertEquals(expectedList, df.getMessages());
		Assertions.assertTrue(df.getFormatedMsg().contains("], msg:[message test]"));
		Assertions.assertTrue(df.getFormatedMsg().contains("code:[CODE], date:["));
	}
}