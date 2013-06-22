/*
 * Semiprimes
 * Problem 187
 * A composite is a number containing at least two prime factors. For example, 15 = 3 × 5; 9 = 3 × 3; 12 = 2 × 2 × 3.

 * There are ten composites below thirty containing precisely two, not necessarily distinct, prime factors: 4, 6, 9, 10, 
 * 14, 15, 21, 22, 25, 26.

 * How many composite integers, n < 10^8, have precisely two, not necessarily distinct, prime factors?
 */
package number;


public class Semiprimes {
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
	public static void main(String[] args) {
		long start = System.nanoTime();
		int[] list = primeArray(50000020);
		int count = 0; 
		for(int i = 0; list[i] < 10000; i++) {
			int limit = 100000000 / list[i];
			for(int j = i; list[j] <= limit; j++) 
				count++;
		}
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
