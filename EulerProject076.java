/*
 * Counting summations
 * Problem 76
 * It is possible to write five as a sum in exactly six different ways:

 *           4 + 1
 *    	 3 + 2
 * 			 3 + 1 + 1
 * 			 2 + 2 + 1
 * 			 2 + 1 + 1 + 1
 * 			 1 + 1 + 1 + 1 + 1

 * How many different ways can one hundred be written as a sum of at least two positive integers?
 */
package number;

public class CountingSummations {
	public static void main(String[] args) {
		long start = System.nanoTime();
		int[] ways = new int[101];
		ways[0] = 1;
		for(int i = 1; i <= 99; i++) {
			for(int j = i; j <= 100; j++)
				ways[j] += ways[j - i];
		}
		System.out.println(ways[100]);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
