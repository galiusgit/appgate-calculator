package com.appgate.calc.domain.service;

import java.math.BigDecimal;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.ArithmeticOperator;
import com.appgate.calc.domain.util.DecimalUtil;

/**
 * The Class CalcProcessorImpl.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcProcessorImpl implements CalcProcessor {

	private static final String CALC_VALIDATION = "CALC_VALIDATION";
	
	private static final String CALC_ERROR = "CALC_ERROR";

	@Override
	public BigDecimal applyOperator(BigDecimal value1, BigDecimal value2, ArithmeticOperator operator)
			throws AppCalcException {
		initialValidations(value1, value2, operator);
		BigDecimal result = null;
		try {
			switch (operator) {
			case SUM:
				result = DecimalUtil.scaleValue(value1.add(value2));
				break;
			case SUBTRACT:
				result = DecimalUtil.scaleValue(value1.subtract(value2));
				break;
			case MULTIPLY:
				result = DecimalUtil.scaleValue(value1.multiply(value2));
				break;
			case DIVIDE:
				result = DecimalUtil.scaleValue(value1.divide(value2));
				break;
			case POW:
				result = DecimalUtil.scaleValue(value1.pow(value2.intValue()));
				break;
			default:
				throw new AppCalcException(CALC_VALIDATION,
						String.format("No supported operator, operator:[%s]", operator.name()));
			}
		} catch (ArithmeticException e) {
			throw new AppCalcException(CALC_ERROR, String.format("Arithmetic error:[%s]", e.getMessage()), e);
		}
		return result;
	}

	private void initialValidations(BigDecimal value1, BigDecimal value2, ArithmeticOperator operator)
			throws AppCalcException {
		if (value1 == null) {
			throw new AppCalcException(CALC_VALIDATION, "The value1 cannot be null");
		}
		if (value2 == null) {
			throw new AppCalcException(CALC_VALIDATION, "The value2 cannot be null");
		}
		if (operator == null) {
			throw new AppCalcException(CALC_VALIDATION, "The operator cannot be null");
		}
		if (ArithmeticOperator.NONE.equals(operator)) {
			throw new AppCalcException(CALC_VALIDATION, "None operator");
		}
	}

}
