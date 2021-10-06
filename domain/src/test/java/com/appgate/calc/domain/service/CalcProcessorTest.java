package com.appgate.calc.domain.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.exception.AppCalcException;
import com.appgate.calc.domain.model.ArithmeticOperator;

/**
 * The Class CalcProcessorTest.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class CalcProcessorTest {
	
	/** The calc processor. */
	private CalcProcessor calcProcessor = new CalcProcessorImpl();
	
	/**
	 * Sum.
	 *
	 * @throws AppCalcException the app calc exception
	 */
	@Test
    public void sum() throws AppCalcException {
    	BigDecimal value1 = new BigDecimal("20.05");
    	BigDecimal value2 = new BigDecimal("20.05");
    	BigDecimal expectedResult = new BigDecimal("40.10");
    	BigDecimal result = calcProcessor.applyOperator(value1, value2, ArithmeticOperator.SUM);
    	Assertions.assertEquals(expectedResult, result);
    }
	
    /**
     * Sub 1.
     *
     * @throws AppCalcException the app calc exception
     */
    @Test
    public void sub1() throws AppCalcException {
    	BigDecimal value1 = new BigDecimal("10.05");
    	BigDecimal value2 = new BigDecimal("20.05");
    	BigDecimal expectedResult = new BigDecimal("-10.00");
    	BigDecimal result = calcProcessor.applyOperator(value1, value2, ArithmeticOperator.SUBTRACT);
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    /**
     * Sub 2.
     *
     * @throws AppCalcException the app calc exception
     */
    @Test
    public void sub2() throws AppCalcException {
    	BigDecimal value1 = new BigDecimal("30.02");
    	BigDecimal value2 = new BigDecimal("20.05");
    	BigDecimal expectedResult = new BigDecimal("9.97");
    	BigDecimal result = calcProcessor.applyOperator(value1, value2, ArithmeticOperator.SUBTRACT);
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    /**
     * Multiply 1.
     *
     * @throws AppCalcException the app calc exception
     */
    @Test
    public void multiply1() throws AppCalcException {
    	BigDecimal value1 = new BigDecimal("3");
    	BigDecimal value2 = new BigDecimal("4");
    	BigDecimal expectedResult = new BigDecimal("12.00");
    	BigDecimal result = calcProcessor.applyOperator(value1, value2, ArithmeticOperator.MULTIPLY);
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    /**
     * Multiply 2.
     *
     * @throws AppCalcException the app calc exception
     */
    @Test
    public void multiply2() throws AppCalcException {
    	BigDecimal value1 = new BigDecimal("20.06");
    	BigDecimal value2 = new BigDecimal("0.00");
    	BigDecimal expectedResult = new BigDecimal("0.00");
    	BigDecimal result = calcProcessor.applyOperator(value1, value2, ArithmeticOperator.MULTIPLY);
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    /**
     * Multiply 3.
     *
     * @throws AppCalcException the app calc exception
     */
    @Test
    public void multiply3() throws AppCalcException {
    	BigDecimal value1 = new BigDecimal("20.06");
    	BigDecimal value2 = new BigDecimal("-1.00");
    	BigDecimal expectedResult = new BigDecimal("-20.06");
    	BigDecimal result = calcProcessor.applyOperator(value1, value2, ArithmeticOperator.MULTIPLY);
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    /**
     * Divide 1.
     *
     * @throws AppCalcException the app calc exception
     */
    @Test
    public void divide1() throws AppCalcException {
    	BigDecimal value1 = new BigDecimal("100");
    	BigDecimal value2 = new BigDecimal("5");
    	BigDecimal expectedResult = new BigDecimal("20.00");
    	BigDecimal result = calcProcessor.applyOperator(value1, value2, ArithmeticOperator.DIVIDE);
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    /**
     * Divide 2.
     */
    @Test
    public void divide2() {
    	BigDecimal value1 = new BigDecimal("100");
    	BigDecimal value2 = new BigDecimal("0");
    	Exception exception1 = Assertions.assertThrows(AppCalcException.class, () -> {
        	 calcProcessor.applyOperator(value1, value2, ArithmeticOperator.DIVIDE);
		});
		Assertions.assertTrue(exception1.getMessage().contains("Division by zero"));
    }
    
    /**
     * Pow 1.
     *
     * @throws AppCalcException the app calc exception
     */
    @Test
    public void pow1() throws AppCalcException {
    	BigDecimal value1 = new BigDecimal("2");
    	BigDecimal value2 = new BigDecimal("3");
    	BigDecimal expectedResult = new BigDecimal("8.00");
    	BigDecimal result = calcProcessor.applyOperator(value1, value2, ArithmeticOperator.POW);
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    /**
     * Pow 2.
     *
     * @throws AppCalcException the app calc exception
     */
    @Test
    public void pow2() throws AppCalcException {
    	BigDecimal value1 = new BigDecimal("2.17");
    	BigDecimal value2 = new BigDecimal("3");
    	BigDecimal expectedResult = new BigDecimal("10.22");
    	BigDecimal result = calcProcessor.applyOperator(value1, value2, ArithmeticOperator.POW);
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    

}
