/*
 * Goldbach's other conjecture
 * Problem 46
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

 *             9 = 7 + 2×1^2
 *   		   15 = 7 + 2×2^2
 *  		   21 = 3 + 2×3^2
 * 			   25 = 7 + 2×3^2
 *			   27 = 19 + 2×2^2
 *			   33 = 31 + 2×1^2

 * It turns out that the conjecture was false.

 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
package number;

public class GoldbachOtherConjecture {
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
	public static boolean isGoOtherCon(int n) {
		int end = (int) Math.sqrt(n / 2);
		for(int i = 0; i <= end; i++) {
			int temp = n - 2 * i * i;
			if(isPrime(temp))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int i = 1; 
		while(isGoOtherCon(2 * i + 1)) 
			i++;
		System.out.println(2 * i + 1);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
