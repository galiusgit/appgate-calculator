package com.appgate.calc.domain;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.util.JsonUtil;

public class JsonUtilTest {

	@Test
	public void jsonUtil() throws IOException {
		var mapper = JsonUtil.getMapper();
		Assertions.assertNotNull(mapper);
		@SuppressWarnings("unchecked")
		Map<String, Integer> resultMap = JsonUtil.mapFromJson("{\"attr1\":1,\"attr2\":3}", Map.class);
		Assertions.assertNotNull(resultMap);
		Assertions.assertEquals(1, resultMap.get("attr1"));
		Assertions.assertEquals(3, resultMap.get("attr2"));
	}
}
