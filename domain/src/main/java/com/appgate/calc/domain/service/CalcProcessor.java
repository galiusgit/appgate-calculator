package com.appgate.calc.domain.service;

import java.math.BigDecimal;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.ArithmeticOperator;

public interface CalcProcessor {

	public BigDecimal applyOperator(BigDecimal value1, BigDecimal value2, ArithmeticOperator operator)
			throws AppCalcException;

}
