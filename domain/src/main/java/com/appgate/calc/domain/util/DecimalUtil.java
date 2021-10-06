package com.appgate.calc.domain.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The Class DecimalUtil.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class DecimalUtil {
	
	/**
	 * Instantiates a new decimal util.
	 */
	private DecimalUtil(){
        throw new IllegalStateException("Utility class");
    }
	
	/**
	 * Scale value.
	 *
	 * @param value the value
	 * @return the big decimal
	 */
	public static BigDecimal scaleValue(BigDecimal value) {
		return value.setScale(2, RoundingMode.HALF_UP);
	}

}
