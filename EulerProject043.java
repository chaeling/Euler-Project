/*
 * Sub-string divisibility
 * Problem 43
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in 
 * some order, but it also has a rather interesting sub-string divisibility property.

 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

 *                                      d2d3d4=406 is divisible by 2
 *   					d3d4d5=063 is divisible by 3
 * 					d4d5d6=635 is divisible by 5
 * 					d5d6d7=357 is divisible by 7
 * 					d6d7d8=572 is divisible by 11
 * 					d7d8d9=728 is divisible by 13
 * 					d8d9d10=289 is divisible by 17
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
package number;

import java.util.*;

public class SubstringDivisibility {
	private static ArrayList<String> permutations(String s){
		ArrayList<String> list = new ArrayList<String>();
		permutations(list, "", s);
		return list;
	}
	private static void permutations(ArrayList<String> list, String prefix, String s) {
		int len = s.length();
		if(len == 0)
			list.add(prefix);
		else{
			for(int i = 0; i < len; i++)
				permutations(list, prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, len));
		}
	}
	static int[] prime = {2, 3, 5, 7, 11, 13, 17};
	public static boolean isDivisible(String s) {
		for(int i = 1; i <= 7; i++) {
			int temp = Integer.valueOf(s.substring(i, i + 3));
			if(temp % prime[i - 1] != 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		long sum = 0;
		ArrayList<String> list = permutations("0123456789");
		for(int i = 0; i < list.size(); i++)
			if(isDivisible(list.get(i))) {
				sum += Long.valueOf(list.get(i));
				System.out.println(list.get(i));
			}
		System.out.println("sum = " + sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
