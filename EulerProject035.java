/*Circular primes
 * Problem 35
 */
/*
 * The number, 197, is called a circular prime because all rotations of 
 * the digits: 197, 971, and 719, are themselves prime. There are thirteen 
 * such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * How many circular primes are there below one million?
 */
package number;

public class CircularPrimes {
  
	public static boolean isPrime(int n){
		if(n < 0)
			throw new IllegalArgumentException();
		if(n == 2)
			return true;
		else if(n == 1 | (n > 2 && n%2 == 0))
			return false;
		else{
			for(int i = 2; i <= java.lang.Math.sqrt(n); i++)
				if(n%i == 0)
					return false;		
			return true;
		}
	}	
	public static boolean isCircularPrime(int n){
		if(!isPrime(n))
			return false;
		else{
			String str = Integer.toString(n);
			for(int i = 1; i < str.length(); i++){
				str = str.substring(1, str.length()) + str.charAt(0);
				if(!isPrime(Integer.parseInt(str)))
					return false;
			}
			return true;
		}
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int count = 0;
		for(int i = 1; i < 1000000; i++)
			if(isCircularPrime(i))
				count++;
		System.out.println("count = " + count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime = " + time/1000/1000.0 + " ms.");
	}
}
