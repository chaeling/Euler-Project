/*
 * Totient permutation
 * Problem 70
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of positive 
 * numbers less than or equal to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all 
 * less than nine and relatively prime to nine, φ(9)=6.
 * The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.

 * Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.

 * Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.
 */
package number;

import java.util.*;

public class TotientPermutation {
	public static int[] totient(int n) {
		int[] list = new int[n + 1];
		for(int i = 0; i <= n; i++)
			list[i] = i;
		for(int i = 2; i <= n; i++) {
			if(list[i] == i) { // if i is a prime
				for(int j = i; j <= n; j += i)
					list[j] = list[j] / i * (i - 1);
			}
		}
		return list;
	}
	public static boolean hasSameDigits(int m, int n) {
		char[] array1 = Integer.toString(m).toCharArray();
		char[] array2 = Integer.toString(n).toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		return Arrays.equals(array1, array2);
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int[] totient = totient(10000000);
		float min = 3;
		int result = 0;
		for(int i = 2; i < 10000000; i++) {
			if(hasSameDigits(i, totient[i]) && min > (float) i / totient[i]) {
				min = (float) i / totient[i];
				result = i;
			}
		}
		System.out.println(result);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
  	/*private static int totient(int n) {
		int count = 1;
		for(int i = 2, end = (int) Math.sqrt(n); i <= end; i++) {
			if(n % i == 0) {
				count *= i - 1;
				n /= i;
				while(n % i == 0) {
					count *= i;
					n /= i;
				}
				end = (int) Math.sqrt(n); // This line is not necessary, but it can accelerate the speed.
			}
		}
		if(n != 1)
			count *= n - 1;
		return count;
	}
	public static boolean isTotientPermutation(int n) {
		char[] array1 = Integer.toString(n).toCharArray();
		char[] array2 = Integer.toString(totient(n)).toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		return Arrays.equals(array1, array2);
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		float min = 4;
		int result = 0;
		for(int i = 2; i < 10000000; i++)
			if(isTotientPermutation(i) && min >= (float) i / totient(i)) {
				min = (float) i / totient(i);
				result = i;
				System.out.println(i + "/" + totient(i) + " = " + (float) i / totient(i));
			}
		System.out.println("result = " + result);
			
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}*/
}
