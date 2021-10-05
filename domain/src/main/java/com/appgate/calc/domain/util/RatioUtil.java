package com.appgate.calc.domain.util;

/**
 * The Class RatioUtil.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class RatioUtil {
	
	/**
	 * Instantiates a new ratio util.
	 */
	private RatioUtil(){
        throw new IllegalStateException("Utility class");
    }
	
	/**
	 * Gcd.
	 *
	 * @param p the p
	 * @param q the q
	 * @return the int
	 */
	private static int gcd(int p, int q) {
	    if (q == 0) {
	    	return p;
	    }
	    return gcd(q, p % q);
	}

	/**
	 * Ratio.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the int
	 */
	public static int ratio(int a, int b) {
	   final int gcd = gcd(a, b);
	   //System.out.println(a/gcd + " " + b/gcd);
	   return gcd;
	}

}
