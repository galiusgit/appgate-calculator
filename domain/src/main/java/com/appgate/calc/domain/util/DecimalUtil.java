package com.appgate.calc.domain.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalUtil {
	
	private DecimalUtil(){
        throw new IllegalStateException("Utility class");
    }
	
	public static BigDecimal scaleValue(BigDecimal value) {
		return value.setScale(2, RoundingMode.HALF_UP);
	}

}
