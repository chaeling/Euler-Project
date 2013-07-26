/*
 * Generalised Hamming Numbers
 * Problem 204
 * A Hamming number is a positive number which has no prime factor larger than 5.
 * So the first few Hamming numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15.
 * There are 1105 Hamming numbers not exceeding 10^8.

 * We will call a positive number a generalised Hamming number of type n, if it has no prime factor larger than n.
 * Hence the Hamming numbers are the generalised Hamming numbers of type 5.

 * How many generalised Hamming numbers of type 100 are there which don't exceed 10^9?
 */
package number;

import java.util.*;

public class GeneralisedHammingNumbers {
  public static int[] primeList(int n) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		boolean[] list = new boolean[n + 1];
		for(int i = 0; i <= n; i++) 
			list[i] = true;
		for(int i = 2; i <= n; i++) {
			if(list[i]) {
				set.add(i);
				for(int j = i * i; j <= n; j += i) {
					list[j] = false;
				}
			}
		}
		int[] primes = new int[set.size()];
		int i = 0;
		for(int value : set)
			primes[i++] = value;
		return primes;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		
		int LIMIT = 1000000000;
		int[] primes = primeList(100);
		int[] hamming = new int[10000000];
		hamming[0] = 1;
		int cursor = 1, maxCursor, k, value;
		for(int i = 0; i < primes.length; i++) {
			maxCursor = cursor;
			k = 1;
			while(true) {
				if(Math.pow(primes[i], k) > LIMIT)
					break;
				for(int j = 0; j < maxCursor; j++) {
					value = (int) (hamming[j] * Math.pow(primes[i], k));
					if(value > LIMIT)
						continue;
					else
						hamming[cursor++] = value;
				}
				k++;
			}
		}
		System.out.println(cursor);
		
		System.out.println("Runtime is " + (System.nanoTime() - start) / 1000 /1000.0 + " ms.");
	}
}
