/*
 * Consecutive positive divisors
 * Problem 179
 * 
 * Find the number of integers 1 < n < 10^7, for which n and n + 1 have the same number of positive divisors. For 
 * example, 14 has the positive divisors 1, 2, 7, 14 while 15 has 1, 3, 5, 15.
 */
package number;

import java.util.Arrays;

public class ConsecutivePositiveDivisors {
  public static void main(String[] args) {
		long start = System.nanoTime();
		final int LIMIT = 10000000;
		int[] array = new int[LIMIT + 1];
		Arrays.fill(array, 2);
		for(int i = 2; i <= Math.sqrt(LIMIT); i++) {
			int j = i * i;
			array[j]--;
			while(j < LIMIT) {
				array[j] += 2;
				j += i;
			}
		}
		int count = 0;
		for(int i = 2; i < LIMIT; i++)
			if(array[i] == array[i + 1])
				count++;
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
