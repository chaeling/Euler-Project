/*
 * Red, green, and blue tiles
 * Problem 117
 * Using a combination of black square tiles and oblong tiles chosen from: red tiles measuring two units, 
 * green tiles measuring three units, and blue tiles measuring four units, it is possible to tile a row 
 * measuring five units in length in exactly fifteen different ways.
 * 
 * http://projecteuler.net/problem=117
  		
 * How many ways can a row measuring fifty units in length be tiled?

 * NOTE: This is related to problem 116.
 */
package number;

public class RedGreenBlueTilesII {
	public static long tilesSum(int n) {
		long[] sum = new long[n + 1];
		sum[0] = 1;
		for(int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1];
			if(i >= 2)
				sum[i] += sum[i - 2];
			if(i >= 3)
				sum[i] += sum[i - 3];
			if(i >= 4)
				sum[i] += sum[i - 4];
		}
		return sum[n];
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(tilesSum(50));
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
