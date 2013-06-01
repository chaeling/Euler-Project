/*
 * Large non-Mersenne prime
 * Problem 97
 * 
 * The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the
 *  form 26972593−1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2^p−1, 
 *  have been found which contain more digits.

 * However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×2^7830457+1.

 * Find the last ten digits of this prime number.
 */
package number;

import java.math.BigInteger;

public class LargeNonMersennePrime {
  public static void main(String[] args) {
		long start = System.nanoTime();
		
/*		long i = 28433;
		for(int j = 1; j <= 7830457; j++) {
			i *= 2;
			i %= 10000000000L;
		}
		i += 1;
		System.out.println(i);*/
		
		long mod = 10000000000L;
		BigInteger num = BigInteger.valueOf(28433).multiply(BigInteger.valueOf(2).modPow(BigInteger.valueOf(7830457), BigInteger.valueOf(mod))).add(BigInteger.ONE);
		num = num.mod(BigInteger.valueOf(mod));
		System.out.println(num);
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
