/*
 * Ordered radicals
 * Problem 124
 * 
 * The radical of n, rad(n), is the product of distinct prime factors of n. For example, 504 = 23 × 32 × 7, 
 * so rad(504) = 2 × 3 × 7 = 42.

 * If we calculate rad(n) for 1 ≤ n ≤ 10, then sort them on rad(n), and sorting on n if the radical values 
 * are equal, we get:
 * 
                       Unsorted                                           Sorted

                     n     rad(n)                                     n   rad(n)   k
                     1       1                                        1      1     1
                     2       2 	                	              2      2	   2
                     3       3  			              4      2     3
	             4       2                                        8      2     4
                     5       5                                        3      3     5
                     6       6                                        9      3     6
                     7       7                                        5      5     7
                     8       2                                        6      6     8
                     9       3                                        7      7     9
                     10      10                                       10     10    10
                     
 * Let E(k) be the kth element in the sorted n column; for example, E(4) = 8 and E(6) = 9.

 * If rad(n) is sorted for 1 ≤ n ≤ 100000, find E(10000).
 */
package number;

import java.util.Arrays;

public class OrderedRadicals {	
	public static int rad(int n){
		int product = 1;
		for(int i = 2; i <= Math.sqrt(n); i++){
			if(n % i == 0){
				product *= i;
				while(n % i == 0)
					n /= i;
			}				
		}
		if(n > 1)
			product *= n;
		return product;
	}
	
	private static class Radical implements Comparable<Radical>{
		public int id, rad;
		public Radical(int rad, int id) {
			this.rad = rad;
			this.id = id;
		}
		public int compareTo(Radical radical) {
			if(this.rad > radical.rad)
				return 1;
			else if(this.rad < radical.rad)
				return -1;
			else{
				if(this.id == radical.id)
					return 0;
				return this.id > radical.id ? 1 : -1;
			}
		}
	}
	
/*	public static void main(String[] args) {
		long start = System.nanoTime();
		final int LIMIT = 100001;
		int[] rads = new int[LIMIT];
		Arrays.fill(rads, 1);
		for(int i = 2; i < LIMIT; i++){
			if(rads[i] == 1){
				rads[i] = i;
				for(int n = i + i; n < LIMIT; n += i)
					rads[n] *= i;
			}
		}
		Radical[] radicals = new Radical[LIMIT - 1];
		for(int i = 1; i < LIMIT; i++)
			radicals[i - 1] = new Radical(rads[i], i);
		Arrays.sort(radicals);
		System.out.println(radicals[9999].id);
		long time = System.nanoTime() -start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}*/
	public static void main(String[] args) {
		long start = System.nanoTime();	
		final int len = 100000;
		Radical[] rads = new Radical[len];
		for(int i = 0; i < len; i++){
			rads[i] = new Radical(rad(i + 1), i + 1);
		}
		Arrays.sort(rads);
		System.out.println(rads[9999].id);	
		long time = System.nanoTime() -start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
