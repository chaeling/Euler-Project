/*
 * Truncatable primes
 * Problem 37
 * 
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove 
 * digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly 
 * we can work from right to left: 3797, 379, 37, and 3.

 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
package number;

public class TruncatablePrimes {
  private static boolean isTruPrime(int n){
		int len = Integer.toString(n).length();
		int temp = n;
		while(n > 0){
			if(!isPrime(n))
				return false;
			else
				n /= 10;
		}
		
		while(temp > 0){
			if(!isPrime(temp))
				return false;
			else{
				len = Integer.toString(temp).length();
				temp %= Math.pow(10, len - 1);
			}
		}
		return true;
	}
	public static boolean isPrime(int n){
		if(n < 10)
			return (n == 2 || n == 3 || n == 5 || n == 7);
		else{
			if(n%2 != 0){
				for(int i = 3; i <= Math.sqrt(n); i += 2)
					if(n%i == 0)
						return false;
				return true;
			}
			return false;
		}
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int sum = 0;
		for(int j = 23; j < 1000000; j++)
			if(isTruPrime(j)){
				System.out.println(j);
				sum += j;
			}
		System.out.println("Sum = " + sum);
		long time = System.nanoTime() - start; 
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
