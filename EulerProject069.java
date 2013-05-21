/*
 * Totient maximum
 * Problem 69
 * 
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number 
 * of numbers less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all 
 * less than nine and relatively prime to nine, φ(9)=6.

 * n	Relatively Prime	φ(n)	n/φ(n)
 * 2	1	                  1	      2
 * 3	1,2                   2	      1.5
 * 4	1,3	                  2	      2
 * 5	1,2,3,4	              4	      1.25
 * 6	1,5	                  2	      3
 * 7	1,2,3,4,5,6	          6	      1.1666...
 * 8	1,3,5,7            	  4       2
 * 9	1,2,4,5,7,8	          6	      1.5
 * 10	1,3,7,9	              4	      2.5
 
 * It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.

 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 */
package number;

public class TotientMaximum {
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
				end = (int) Math.sqrt(n);
			}
		}
		if(n != 1)
			count *= n - 1;
		return count;
	}

	private static float phiRatio(int n){
		return (float)n/totient(n);
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(phiRatio(6));
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
	
	// The method below is much more efficient, but ……
	/*public static void main(String[] args) {
		long start = System.nanoTime();
		int primes[] = new int[500];
		int count = 0;
		for(int i = 2; i < 1000; i++)
			if(isPrime(i)){
				primes[count] = i;
				count++;
			}
		int max = 1;
		int j = 0;
		while(max * primes[j]< 1000000){
			max *= primes[j];
			j++;
		}
		System.out.println(max);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}*/
}
