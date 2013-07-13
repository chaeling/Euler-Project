/*
 * Pandigital Fibonacci ends
 Problem 104
 The Fibonacci sequence is defined by the recurrence relation:

 Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 It turns out that F541, which contains 113 digits, is the first Fibonacci number for which the last nine digits 
 are 1-9 pandigital (contain all the digits 1 to 9, but not necessarily in order). And F2749, which contains 575 
 digits, is the first Fibonacci number for which the first nine digits are 1-9 pandigital.

 Given that Fk is the first Fibonacci number for which the first nine digits AND the last nine digits are 1-9 
 pandigital, find k.
 */
package number;

import java.math.BigInteger;
import java.util.*;

public class PandigitalFibonacciEnds {
	
	public static boolean isPandigital(int n) {
		if(n < 123456789)
			return false;
		char[] temp = Integer.toString(n).toCharArray();
		Arrays.sort(temp);
		return new String(temp).equals("123456789");
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		int count = 2;
		BigInteger cur1 = BigInteger.ONE;
		BigInteger cur2 = BigInteger.ONE;
		BigInteger fibo = BigInteger.ZERO;
		BigInteger standard = BigInteger.valueOf(1000000000);
		
		int pre9digits = 0, end9digits = 0;
		boolean isFound = false;
		while(!isFound) {
			count++;
			fibo = cur1.add(cur2);
			end9digits = fibo.mod(standard).intValue();
			if(isPandigital(end9digits)) {
				int length = fibo.toString().length();
				if(length > 9) {
					pre9digits = fibo.divide(BigInteger.valueOf(10).pow(length - 9)).intValue();
					if(isPandigital(pre9digits))
						isFound = true;
				}
			}
			cur1 = cur2;
			cur2 = fibo;
		}
		System.out.println(count);
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
