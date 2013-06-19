/*
 * Prime pair connection
 * Problem 134
 * Consider the consecutive primes p1 = 19 and p2 = 23. It can be verified that 1219 is the smallest number such 
 * that the last digits are formed by p1 whilst also being divisible by p2.

 * In fact, with the exception of p1 = 3 and p2 = 5, for every pair of consecutive primes, p2 > p1, there exist 
 * values of n for which the last digits are formed by p1 and n is divisible by p2. Let S be the smallest of these 
 * values of n.

 * Find ∑ S for every pair of consecutive primes with 5 ≤ p1 ≤ 1000000.
 */
package number;

public class PrimePairConnection {
  private static long[] primeArray(int n){
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

	static long[] list = primeArray(1000003);
	public static int s(int n) {
		int value = 0;
		int i = 1;
		int len = Long.toString(list[n]).length();
		value = (int) (i * Math.pow(10, len) + list[n]);
		while(value % list[n + 1] != 0) {
			i++;
			value = (int) (i * Math.pow(10, len) + list[n]);
		}
		return value;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		long sum = 0;
		for(int i = 2; i < list.length; i++)
			sum += s(i);
		System.out.println(sum);

		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
