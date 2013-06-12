/*
 * Prime square remainders
 * Problem 123
 * Let pn be the nth prime: 2, 3, 5, 7, 11, ..., and let r be the remainder when (pn−1)^n + (pn+1)^n is divided by pn^2.

For example, when n = 3, p3 = 5, and 4^3 + 6^3 = 280 ≡ 5 mod 25.

The least value of n for which the remainder first exceeds 10^9 is 7037.

Find the least value of n for which the remainder first exceeds 10^10.
 * 
 */
package number;


public class PrimeSquareRemainders {
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
	public static void main(String[] args) {
		long start = System.nanoTime();
		long[] list = primeArray(1000000);
		int i;
		for(i = 5; 2 * (i + 1) * list[i] <= 10000000000L; i +=2);
		System.out.println(i + 1);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
