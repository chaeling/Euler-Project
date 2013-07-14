/*
 * Combinatoric selections
 * Problem 53
 * 
 * There are exactly ten ways of selecting three from five, 12345:

 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

 * In combinatorics, we use the notation, 5C3 = 10.

 * In general,

 *        nCr =	n!/(r!(n−r)!), where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 */
package number;

import java.math.BigInteger;

public class CombinatoricSelections {
	private static BigInteger factorial(int m, int n){
		if(m > n)
			throw new IllegalArgumentException();
		BigInteger value = BigInteger.ONE;
		for(int i = n - m + 1; i <= n; i++)
			value = value.multiply(BigInteger.valueOf(i));
		return value;
	}
	
	public static BigInteger combination(int m, int n){
		if(m > n)
			throw new IllegalArgumentException();
		return factorial(m, n).divide(factorial(m, m));
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		int count = 0;
		for(int i = 1; i <= 100; i++)
			if(combination(i / 2, i).compareTo(BigInteger.valueOf(1000000)) > 0) {
				int j;
				for(j = i / 2; combination(j, i).compareTo(BigInteger.valueOf(1000000)) > 0; j--);
				j++;
				count += i - 2 * j + 1;
			}
		System.out.println(count);
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}	
}
