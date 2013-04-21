/* Summation of primes */
/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
package number;

import java.util.ArrayList;

public class SummationOfPrimes {
  private static boolean isPrime(long n){
		if(n < 2)
			return false;
		else if(n == 2)
			return true;
		else if(n%2 == 0)
			return false;
		else{
			for(long i = 2; i <= java.lang.Math.sqrt(n); i++)
				if(n%i == 0)
					return false;
			return true;
		}
	}
	public static long SumOfPrime(int n){
		long sum = 0;
		for(int i = 2; i <= n; i++)
			if(isPrime(i))
				sum += i;
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(SumOfPrime(2000000));
	}

}
