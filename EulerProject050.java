/*
 * Consecutive prime sum
 * Problem 50
 * The prime 41, can be written as the sum of six consecutive primes:

 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.

 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
package number;

import java.util.*;

public class ConsecutivePrimeSum {
	public static int[] primeArray(int n) {
		if(n <= 0) 
			throw new IllegalArgumentException("Please input a positive number");
		boolean[] prime = new boolean[n + 1];
		prime[0] = prime[1] = false;
		for(int i = 2; i <= n; i++)
			prime[i] = true;
		for(int i = 2; i * i <= n; i++)
			if(prime[i])
				for(int j = i * i; j <= n; j += i)
					prime[j] = false;
		
		int count = 0; 
		for(int i = 0; i <= n; i++)
			if(prime[i])
				count++;
		
		int[] array = new int[count];
		int j = 0;
		for(int i = 0; i <= n; i++)
			if(prime[i]) {
				array[j] = i;
				j++;
			}
		return array;
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		final int N = 1000000;
		int maxLength = 0, result = 0;
		int[] prime = primeArray(N);
		List<Integer> list = new ArrayList<Integer>();
		list.add(prime[0]);
		for(int i = 1; list.get(i - 1) + prime[i] < N; i++) {
			list.add(list.get(i - 1) + prime[i]);
		}
			
		for(int i = 0; i < list.size(); i++)
			for(int j = i + 1; j < list.size(); j++) {
				int diff = list.get(j) - list.get(i);
				if(Arrays.binarySearch(prime, diff) > 0){
					if(j - i > maxLength) {
						maxLength = j - i;
						result = (int) diff;
					}
				}
			}
		System.out.println("maxLength = " + maxLength);
		System.out.println("result = " + result);
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
