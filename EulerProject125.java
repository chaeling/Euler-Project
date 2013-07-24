/*
 * Palindromic sums
 * Problem 125
 * The palindromic number 595 is interesting because it can be written as the sum of consecutive squares: 
 * 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.

 * There are exactly eleven palindromes below one-thousand that can be written as consecutive square sums, 
 * and the sum of these palindromes is 4164. Note that 1 = 0^2 + 1^2 has not been included as this problem is 
 * concerned with the squares of positive integers.

 * Find the sum of all the numbers less than 10^8 that are both palindromic and can be written as the sum of 
 * consecutive squares.
 */
package number;

import java.util.*;

public class PalindromicSums {

  public static boolean isPalindrome(int n) {
		return new StringBuilder(n + "").reverse().toString().equals(Integer.toString(n));
	}
	
	public static void main(String[] args) {	
		long start = System.nanoTime();
		int LIMIT = 100000000, end = (int) Math.sqrt(LIMIT);
		long sum = 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 1; i < end; i++) {
			int tempSum = 0;
			for(int j = i; j < end; j++) {			
				tempSum += j * j;
				if(tempSum > LIMIT)
					break;
				if(isPalindrome(tempSum) && !set.contains(tempSum) && j != i) {
					sum += tempSum;
					set.add(tempSum);
				}
			}
		}
		System.out.println(sum);
		System.out.println(set);
			
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
