/*
 * Prime summations
 * Problem 77
 * It is possible to write ten as the sum of primes in exactly five different ways:

 *   					7 + 3
 * 					5 + 5
 * 					5 + 3 + 2
 * 					3 + 3 + 2 + 2
 * 					2 + 2 + 2 + 2 + 2

 * What is the first value which can be written as the sum of primes in over five thousand different ways?
 */
package number;

public class PrimeSummations {
	private static int[] primeArray(int n){
		// This function is to get a prime array whose largest element doesn't exceed the input number n.
		if(n < 0)
			throw new IllegalArgumentException("Negative number");
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
		int[] array = new int[count];
		int j = 0;
		for(int i = 0; i <= n; i++) {
			if(prime[i]) {
				array[j] = i;
				j++;
			}
		}
		return array;
	}
	public static int waysOfPrime(int n) {
		int[] prime = primeArray(n);
		int[] ways = new int[n + 1];
		ways[0] = 1;
		for(int i = 0; i < prime.length; i++) 
			for(int j = prime[i]; j <= n; j++)
				ways[j] += ways[j - prime[i]];
		return ways[n];
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int i;
		for(i = 10; waysOfPrime(i) <= 5000; i++);
		System.out.println(i);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
