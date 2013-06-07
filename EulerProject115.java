/*
 * Counting block combinations II
 * Problem 115
 * NOTE: This is a more difficult version of problem 114.
 * 
 * http://projecteuler.net/problem=115

 * A row measuring n units in length has red blocks with a minimum length of m units placed on it, such that any
 *  two red blocks (which are allowed to be different lengths) are separated by at least one black square.

 * Let the fill-count function, F(m, n), represent the number of ways that a row can be filled.

 * For example, F(3, 29) = 673135 and F(3, 30) = 1089155.

 * That is, for m = 3, it can be seen that n = 30 is the smallest value for which the fill-count function first 
 * exceeds one million.

 * In the same way, for m = 10, it can be verified that F(10, 56) = 880711 and F(10, 57) = 1148904, so n = 57 is 
 * the least value for which the fill-count function first exceeds one million.

 * For m = 50, find the least value of n for which the fill-count function first exceeds one million.
 */
package number;

import java.util.ArrayList;
import java.util.List;

public class CountingBlockCombinationsII {
/*  public static long countBlock(int m, int n) {
		long[] sum = new long[n + 1];
		for(int i = 0; i < m; i++) 
			sum[i] = 1;
		for(int i = m; i <= n; i++) {
			sum[i] += sum[i - 1] + 1;
			for(int j = m; j < i; j++)
				sum[i] += sum[i - j - 1];
		}
		return sum[n];
	}
	
	public static int firstExceedOneMillion(int m) {
		int n = m;
		while(countBlock(m, n) <= 1000000)
			n++;
		return n;
	}*/
	
	public static int firstExceedOneMillion(){
		List<Long> sums = new ArrayList<Long>();
		sums.add(1L);
		int m = 50;
		for(int n = 1; ; n++) {
			long sum = sums.get(n - 1);
				for(int i = m; i < n; i++) 
					sum += sums.get(n - i - 1);
				if(n >= m)
					sum++;
				sums.add(sum);
				if(sum > 1000000)
					return n;
			}
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
//		System.out.println(firstExceedOneMillion(50));
		System.out.println(firstExceedOneMillion());
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
