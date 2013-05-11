/*
 * Distinct primes factors
 * Problem 47
 * 
 * The first two consecutive numbers to have two distinct prime factors are:
 *                      14 = 2 × 7
 *                      15 = 3 × 5
 * The first three consecutive numbers to have three distinct prime factors are:

*                       644 = 2² × 7 × 23
*                       645 = 3 × 5 × 43
*                       646 = 2 × 17 × 19.

* Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
 */
package number;

public class DistinctPrimesFactors {
/*  public static int primesFactorNum(int n){
		int count = 0;
		for(int i = 2; n != 1; i++)
			if(n%i == 0){
				count++;
				while(n%i == 0)
					n /= i;
			}
		return count;
	}*/
	public static int primesFactorNum(int n){
		int count = 0;
		int end = (int) Math.sqrt(n);
		for(int i = 2; i <= end; i++)
			if(n % i == 0){
				while(n % i == 0)
					n /= i;
				end = (int) Math.sqrt(n);
				count++;
			}
		if(n > 1)
			count++;
		return count;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int i = 1;
		while(!(primesFactorNum(i) == 4 && primesFactorNum(i + 1) == 4 && primesFactorNum(i + 2) == 4 && primesFactorNum(i + 3) == 4)){
			i++;
		}
		System.out.println(i);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
