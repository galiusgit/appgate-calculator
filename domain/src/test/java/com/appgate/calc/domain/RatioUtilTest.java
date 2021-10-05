package com.appgate.calc.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.util.RatioUtil;

public class RatioUtilTest {

	@Test
	public void ratio() {
		Integer result = RatioUtil.ratio(100, 40);
		//System.out.println("---> ratio: " + result);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(20, result);
	}
}
