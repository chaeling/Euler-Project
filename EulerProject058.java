/*
 * Spiral primes
 * Problem 58
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

 *                                              37 36 35 34 33 32 31
 *   					 	38 17 16 15 14 13 30
 * 						39 18  5  4  3 12 29
 * 						40 19  6  1  2 11 28
 * 						41 20  7  8  9 10 27
 *  						42 21 22 23 24 25 26
 *  						43 44 45 46 47 48 49

 * It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is 
 * that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If 
 * this process is continued, what is the side length of the square spiral for which the ratio of primes along both 
 * diagonals first falls below 10%?
 */
package number;

public class SpiralPrimes {
	public static boolean isPrime(int n) {
		if(n < 0)
			throw new IllegalArgumentException("Negative number");
		if(n == 0 || n == 1)
			return false;
		if(n % 2 == 0 || n % 3 == 0 || n % 5 == 0)
			return n == 2 || n == 3 || n == 5;
		for(int i = 7; i * i <= n; i += 2)
				if(n % i == 0)
					return false;
		return true;
	}
	public static int prime(int n) {
		if(isPrime(n))
			return 1;
		else 
			return 0;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();	
		int count = 0, primeNum = 0, i;
		for(i = 1; ; i++) {
			count = 4 * i - 3;
			primeNum += prime(4 * i * i - 10 * i + 7) + prime(4 * i * i - 8 * i + 5) + prime(4 * i * i - 6 * i + 3);
			if(i > 3 && (float) primeNum/count < 0.1)
				break;
		}
		System.out.println("side length = " + (2 * i - 1) + ", primeNum/count = " + primeNum + "/" + count + " = " + (float)primeNum/count);		
		long time = System.nanoTime() - start; 
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
