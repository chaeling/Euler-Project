/*
 * Prime generating integers
 * Problem 357
 * Consider the divisors of 30: 1,2,3,5,6,10,15,30.
 * It can be seen that for every divisor d of 30, d+30/d is prime.

 * Find the sum of all positive integers n not exceeding 100 000 000
 * such that for every divisor d of n, d+n/d is prime.
 * 
 */
package number;

public class PrimeGeneratingIntegers {
/*  public static boolean isPrime(int n) {
		if(n < 0)
			throw new IllegalArgumentException("Negtive number");
		if(n == 0 || n == 1)
			return false;
		if(n % 2 == 0)
			return n == 2;
		if(n % 3 == 0)
			return n ==3;
		if(n % 5 == 0)
			return n == 5;
		for(int i = 7; i * i <= n; i +=2)
			if(n % i == 0)
				return false;
		return true;
	}
	public static boolean isPrimeGenDiv(int n){
		for(int i = 1; i * i <= n; i++)
			if(n % i == 0)
				if(!isPrime(i + n/i))
					return false;
		return true;
	}*/
	
	private static boolean[] isPrime(int n) {
		if(n < 0)
			throw new IllegalArgumentException("Negtive number");
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
	
	static int N = 100000000;
	static boolean[] prime = isPrime(N + 1);
	
	public static boolean isPrimeGenDiv(int n) {
		for(int i = 1; i * i <= n; i++)
			if(n % i == 0)
				if(!prime[i + n/i])
					return false;
		return true;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();	
		long sum = 1;
		for(int i = 2; i <= 100000000; i += 2)
			if(isPrimeGenDiv(i))
				sum += i;
		System.out.println(sum);
		long time = System.nanoTime() -start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
