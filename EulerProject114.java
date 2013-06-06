/*
 * Counting block combinations I
 * Problem 114
 * 
 * http://projecteuler.net/problem=114
 * 
 * A row measuring seven units in length has red blocks with a minimum length of three units placed on it, such 
 * that any two red blocks (which are allowed to be different lengths) are separated by at least one black square. 
 * There are exactly seventeen ways of doing this.
  					
 * How many ways can a row measuring fifty units in length be filled?

 * NOTE: Although the example above does not lend itself to the possibility, in general it is permitted to mix 
 * block sizes. For example, on a row measuring eight units in length you could use red (3), black (1), and red (4).
 */
package number;

public class CountingBlockCombinationsI {
	public static long countBlock(int n) {
		long[] sum = new long[n + 1];
		sum[0] = sum[1] = sum[2] = 1;
		for(int i = 3; i <= n; i++) {
			sum[i] += sum[i - 1] + 1;// situation of leftmost is a black block or just a red block;
			for(int j = 3; j < i; j++) 
				sum[i] += sum[i - j - 1];//situation of leftmost is a  red block with length of j, 
				                         //which one is followed by a black block.
		}
		return sum[n];
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(countBlock(50));
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
