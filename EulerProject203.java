/*
 * Squarefree Binomial Coefficients
 * Problem 203
 * The binomial coefficients nCk can be arranged in triangular form, Pascal's triangle, like this:

 *                                      1  
 *                                  1		1	
 *                              1		2		1	
 *                          1		3		3		1	
 *                      1		4		6		4		1	
 *                  1		5		10		10		5		1	
 *              1		6		15		20		15		6		1	
 *          1		7		21		35		35		21		7		1
 *                                   .........
 * It can be seen that the first eight rows of Pascal's triangle contain twelve distinct numbers: 1, 2, 
 * 3, 4, 5, 6, 7, 10, 15, 20, 21 and 35.

 * A positive integer n is called squarefree if no square of a prime divides n. Of the twelve distinct 
 * numbers in the first eight rows of Pascal's triangle, all except 4 and 20 are squarefree. The sum of 
 * the distinct squarefree numbers in the first eight rows is 105.

 * Find the sum of the distinct squarefree numbers in the first 51 rows of Pascal's triangle.
 */
package number;

import java.util.*;

public class SquarefreeBinomialCoefficients {	
	public static TreeSet<Long> pascaltriangle(int n) {
		TreeSet<Long> set = new TreeSet<Long>();
		long [] arr1 = {1}, arr2 = {1, 1};
		set.add(1L);
		for(int i = 3; i <= n; i++) {
			if(i % 2 == 0) {
				arr2 = new long[i / 2];
				arr2[0] = 1;
				for(int j = 1; j < i / 2; j++) {
					arr2[j] = arr1[j - 1] + arr1[j];
					set.add(arr2[j]);
				}
			} else {
				arr1 = new long[i / 2 + 1];
				arr1[0] = 1;
				arr1[i / 2] = 2 * arr2[i / 2 - 1];
				set.add(arr1[i / 2]);
				for(int j = 1; j < i / 2; j++) {
					arr1[j] = arr2[j - 1] + arr2[j];
					set.add(arr1[j]);
				}
			}
		}
		return set;
	}
	
	private static long[] primeArray(int n){
		// This function is to get a prime array whose largest element doesn't exceed the input number n.
		if(n <= 0)
			throw new IllegalArgumentException("Please input a positive number!");
		boolean[] prime = new boolean[n + 1];
		prime[0] = prime[1] = false;
		for(int i = 2; i <= n; i++)
			prime[i] = true;
		for(int i = 2; i * i <= n; i++)
			if(prime[i]) {
				for(int j = i * i; j <= n; j += i) 
					prime[j] = false;
			}
		int count = 0;
		for(int i = 0; i <= n; i++)
			if(prime[i])
				count++;
		long[] array = new long[count];
		int j = 0;
		for(int i = 0; i <= n; i++) {
			if(prime[i]) {
				array[j] = i;
				j++;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime(); 
		
		TreeSet<Long> set = pascaltriangle(51);
		int LIMIT = (int) Math.sqrt(set.last());		
		long[] primes = primeArray(LIMIT);
		long sum = 0;
		for(long value : set) {
			boolean flag = true;
			for(long prime : primes) {
				if(value % (prime * prime) == 0)
					flag = false;
				if(value < prime * prime)
					break;
			}
			if(flag)
				sum += value;
		}
		System.out.println(sum);
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time / 1000 / 1000.0 + " ms.");
	}
}
