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
  public static void main(String[] args) {
		int n = 1000000;
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i = 2; i * i <= n; i++)
			for(int j = i; j * i <= n; j++)
				prime[i * j] = false;
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			if(prime[i])
				list.add(i);
		
		int len = 1;
		int result = 0;
		for(int i = 0; i < list.size() - 1; i++) {
			int count = 0; 
			int sum = 0, tempSum = 0;
			for(int j = i; j < list.size() - 1; j++) {
				sum += list.get(j);
				if(list.contains(sum)) {
					count = j - i + 1;
					tempSum = sum;
				}
			}
			if(len < count) {
				len = count;
				result = tempSum;
			}
		}
		System.out.println(len);
		System.out.println(result);
	}
}
