/*
 * Powerful digit sum
 * Problem 56
 * 
 * A googol (10^100) is a massive number: one followed by one-hundred zeros; 100100 is almost 
 * unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the 
 * digits in each number is only 1.

 * Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
 */
package number;

import java.math.BigInteger;

public class PowerfulDigitSum {
  /*private static int digitSum(BigInteger n){
		int sum = 0;
		while(!n.equals(BigInteger.ZERO)){
			sum += n.mod(BigInteger.valueOf(10)).intValue();
			n = n.divide(BigInteger.valueOf(10));
		}
		return sum;
	}*/
	private static int digitSum(BigInteger n){
		int sum = 0;
		String s = n.toString();
		for(int i = 0; i < s.length(); i++)
			sum += s.charAt(i) - '0';
		return sum;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int max = 0;
		for(int i = 1; i < 100; i++)
			for(int j = 1; j < 100; j++)
				max = Math.max(max, digitSum(BigInteger.valueOf(i).pow(j)));
		System.out.println(max);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
