/*
 * 1000-digit Fibonacci number
 * Problem 25
 * 
 * The Fibonacci sequence is defined by the recurrence relation:
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 *              F1 = 1
 *              F2 = 1
 *              F3 = 2
 *              F4 = 3
 *              F5 = 5
 *              F6 = 8
 *              F7 = 13
 *              F8 = 21
 *              F9 = 34
 *              F10 = 55
 *              F11 = 89
 *              F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 */
package number;

import java.math.BigInteger;

public class The1000digitsFibonacciNumber {
	public static void main(String[] args) {
		long start = System.nanoTime();
		BigInteger cur1 = BigInteger.ONE;
		BigInteger cur2 = BigInteger.ONE;
		BigInteger fibo = BigInteger.ZERO;
		BigInteger standard = BigInteger.valueOf(10).pow(999);
		int count = 2;
		while(fibo.compareTo(standard) < 0){
			fibo = cur1.add(cur2);
			cur1 = cur2;
			cur2 = fibo;
			count++;
		}
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
