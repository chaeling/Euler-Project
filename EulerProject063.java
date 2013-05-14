/*
 * Powerful digit counts
 * Problem 63
 * 
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit 
 * number, 134217728=8^9, is a ninth power.

 * How many n-digit positive integers exist which are also an nth power?
 */
package number;

import java.math.BigInteger;

public class PowerfulDigitCounts {
/*  public static void main(String[] args) {
		long start = System.nanoTime();
		int count = 0; 
		for(int i = 1; i <= 21; i++){
			int j = 1; 
			while(BigInteger.valueOf(j).pow(i).toString().length() <= i){
				if(BigInteger.valueOf(j).pow(i).toString().length() == i)
					count++;
				j++;
			}
		}
		System.out.println("count = " + count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}*/
	public static void main(String[] args) {
		long start = System.nanoTime();// 10^(n-1) <= x^n < 10^n  => x < 10, that is x = 1, 2, 3, 4, 5, 6, 7, 8, 9.
		int count = 0;                 // When x is 9, 10^(n-1) <= 9^n => n <= (int)(log10/(log10 - log9)) = 21.      
		for(int i = 1; i <= 9; i++)
			count += (int)(Math.log(10)/(Math.log(10)-Math.log(i)));
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
