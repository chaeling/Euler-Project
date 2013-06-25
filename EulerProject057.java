/*
 * Square root convergents
 * Problem 57
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.

 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

 * By expanding this for the first four iterations, we get:

 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first 
 * example where the number of digits in the numerator exceeds the number of digits in the denominator.

 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 */
package number;

import java.math.BigInteger;

public class SquareRootConvergents {
  public static void main(String[] args) {
		long start = System.nanoTime();
		BigInteger numerator = BigInteger.ZERO, denominator = BigInteger.ONE, cache = BigInteger.ZERO;
		int count = 0;
		for(int i = 1; i <= 1000; i++) {
			numerator = denominator;
			denominator = denominator.multiply(BigInteger.valueOf(2)).add(cache);
			cache = numerator;
			if(numerator.add(denominator).toString().length() > denominator.toString().length()) {
				count++;
				//System.out.println("numerator = " + (numerator.add(denominator)) + ",  denominator = " + denominator);
			}
		}
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
