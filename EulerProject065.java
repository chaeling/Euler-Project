/*
 * http://projecteuler.net/problem=65
 */
package number;

import java.math.BigInteger;

public class ConvergentsOfE {
  public static BigInteger numerator(int n) {
		if(n <= 0)
			throw new IllegalArgumentException(" Not a postive input");
		if(n == 1)
			return BigInteger.valueOf(2);
		BigInteger numerator = (n - 1) % 3 == 2 ? BigInteger.valueOf(2 * n / 3) : BigInteger.ONE;
		BigInteger denominator = BigInteger.ONE, cache = numerator;
		for(int i = n - 2; i >= 1; i--) {
			BigInteger temp = i % 3 == 2 ? BigInteger.valueOf(2 * (i + 1) / 3) : BigInteger.ONE;
			numerator = temp.multiply(numerator).add(denominator);
			denominator = cache; 
			cache = numerator;
		}
		return BigInteger.valueOf(2).multiply(numerator).add(denominator);
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
        String str = numerator(100).toString();
        int sum = 0;
        for(int i = 0; i < str.length(); i++)
        	sum += str.charAt(i) - '0';
        System.out.println(sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
