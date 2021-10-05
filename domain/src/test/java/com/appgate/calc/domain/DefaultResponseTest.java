package com.appgate.calc.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.model.DefaultResponse;

public class DefaultResponseTest {

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