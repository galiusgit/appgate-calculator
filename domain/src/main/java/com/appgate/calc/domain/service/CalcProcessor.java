package com.appgate.calc.domain.service;

import java.math.BigDecimal;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.ArithmeticOperator;

/**
 * The Interface CalcProcessor.
 */
public interface CalcProcessor {

	/**
	 * Apply operator.
	 *
	 * @param value1 the value 1
	 * @param value2 the value 2
	 * @param operator the operator
	 * @return the big decimal
	 * @throws AppCalcException the app calc exception
	 */
	public BigDecimal applyOperator(BigDecimal value1, BigDecimal value2, ArithmeticOperator operator)
			throws AppCalcException;

}
