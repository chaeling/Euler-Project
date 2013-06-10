/*
 * Totient Chains
 * Problem 214
 * Let φ be Euler's totient function, i.e. for a natural number n, φ(n) is the number of k, 1 ≤ k ≤ n, 
 * for which gcd(k,n) = 1.

 * By iterating φ, each positive integer generates a decreasing chain of numbers ending in 1.
 * E.g. if we start with 5 the sequence 5,4,2,1 is generated.
 * Here is a listing of all chains with length 4:

 *                                      5,4,2,1
 *   					7,6,2,1
 * 					8,4,2,1
 * 					9,6,2,1
 * 					10,4,2,1
 * 					12,4,2,1
 * 					14,6,2,1
 * 					18,6,2,1
 * Only two of these chains start with a prime, their sum is 12.

 * What is the sum of all primes less than 40000000 which generate a chain of length 25?
 */
package number;

public class TotientChains {
	private static boolean[] isPrime(int n) {//Sieve of Eratosthenes: http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
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
		return prime;
	}	
	private static int totient(int n){
		int count = 1;
		for(int i = 2, end = (int) Math.sqrt(n); i <= end; i++){
			if(n % i == 0){
				count *= i - 1;
				n /= i;
				while(n % i == 0){
					count *= i;
					n /= i;
				}
				end = (int) Math.sqrt(n); // This line is not necessary, but it can accelerate the speed.
			}
		}
		if(n != 1)
			count *= n - 1;
		return count;
	}
	
	static int[] cache = new int[40000000];
	
	public static int totientChain(int n){
		if(n == 0 || n == 1)
			return n;
		if(cache[n] == 0) {
			cache[n] = 1 + totientChain(totient(n));
		}
		return cache[n];
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();	
		boolean[] test = isPrime(40000000);
		long sum = 0;
		for(int i = 40000000; i >= 0; i--)
			if(test[i])
				if(totientChain(i) == 25) {
					sum += i;
					System.out.println("prime = " + i + ", sum =" + sum);
				}
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
