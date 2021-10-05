package com.appgate.calc.domain;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.appgate.calc.domain.util.DecimalUtil;

public class CalcFastTest {
    
    @Test
    public void sum() {
    	BigDecimal value1 = new BigDecimal("20.05");
    	BigDecimal value2 = new BigDecimal("20.05");
    	BigDecimal expectedResult = new BigDecimal("40.10");
    	BigDecimal result = DecimalUtil.scaleValue(value1.add(value2));
    	Assertions.assertEquals(expectedResult, result);
    }
    
    @Test
    public void sub1() {
    	BigDecimal value1 = new BigDecimal("10.05");
    	BigDecimal value2 = new BigDecimal("20.05");
    	BigDecimal expectedResult = new BigDecimal("-10.00");
    	BigDecimal result = DecimalUtil.scaleValue(value1.subtract(value2));
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    @Test
    public void sub2() {
    	BigDecimal value1 = new BigDecimal("30.02");
    	BigDecimal value2 = new BigDecimal("20.05");
    	BigDecimal expectedResult = new BigDecimal("9.97");
    	BigDecimal result = DecimalUtil.scaleValue(value1.subtract(value2));
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    @Test
    public void multiply1() {
    	BigDecimal value1 = new BigDecimal("3");
    	BigDecimal value2 = new BigDecimal("4");
    	BigDecimal expectedResult = new BigDecimal("12.00");
    	BigDecimal result = DecimalUtil.scaleValue(value1.multiply(value2));
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    @Test
    public void multiply2() {
    	BigDecimal value1 = new BigDecimal("20.06");
    	BigDecimal value2 = new BigDecimal("0.00");
    	BigDecimal expectedResult = new BigDecimal("0.00");
    	BigDecimal result = DecimalUtil.scaleValue(value1.multiply(value2));
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    @Test
    public void multiply3() {
    	BigDecimal value1 = new BigDecimal("20.06");
    	BigDecimal value2 = new BigDecimal("-1.00");
    	BigDecimal expectedResult = new BigDecimal("-20.06");
    	BigDecimal result = DecimalUtil.scaleValue(value1.multiply(value2));
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    @Test
    public void divide1() {
    	BigDecimal value1 = new BigDecimal("100");
    	BigDecimal value2 = new BigDecimal("5");
    	BigDecimal expectedResult = new BigDecimal("20.00");
    	BigDecimal result = DecimalUtil.scaleValue(value1.divide(value2));
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    @Test
    public void divide2() {
    	BigDecimal value1 = new BigDecimal("100");
    	BigDecimal value2 = new BigDecimal("0");
    	Exception exception1 = Assertions.assertThrows(ArithmeticException.class, () -> {
        	DecimalUtil.scaleValue(value1.divide(value2));
		});
		Assertions.assertTrue(exception1.getMessage().contains("Division by zero"));
    }
    
    @Test
    public void pow1() {
    	BigDecimal value1 = new BigDecimal("2");
    	BigDecimal value2 = new BigDecimal("3");
    	BigDecimal expectedResult = new BigDecimal("8.00");
    	BigDecimal result = DecimalUtil.scaleValue(value1.pow(value2.intValue()));
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
    @Test
    public void pow2() {
    	BigDecimal value1 = new BigDecimal("2.17");
    	BigDecimal value2 = new BigDecimal("3");
    	BigDecimal expectedResult = new BigDecimal("10.22");
    	BigDecimal result = DecimalUtil.scaleValue(value1.pow(value2.intValue()));
    	//System.out.println("result: " + result);
    	Assertions.assertEquals(expectedResult, result);
    }
    
}
