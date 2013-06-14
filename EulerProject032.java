/*
 * Pandigital products
 * Problem 32
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, 
 * the 5-digit number, 15234, is 1 through 5 pandigital.

 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 
 * through 9 pandigital.

 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
package number;

import java.util.*;

public class PandigitalProducts {
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
	public static void main(String[] args) {
		long start = System.nanoTime();
		List<String> list = permutations("123456789");
		List<Integer> array = new ArrayList<Integer>();
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			int a = Integer.valueOf(list.get(i).substring(0, 1));
			int b = Integer.valueOf(list.get(i).substring(1, 5));
			int c = Integer.valueOf(list.get(i).substring(5));
			if(a * b == c) {
				if(array.contains(c))
					System.out.println(a + " x " + b + " = " + c + " Duplicate product, don't add to sum!");
				else {
					array.add(c);
					System.out.println(a + " x " + b + " = " + c);
				}
			}
		}
		for(int i = 0; i < list.size(); i++) {
			int a = Integer.valueOf(list.get(i).substring(0, 2));
			int b = Integer.valueOf(list.get(i).substring(2, 5));
			int c = Integer.valueOf(list.get(i).substring(5));
			if(a * b == c) {
				if(array.contains(c))
					System.out.println(a + " x " + b + " = " + c + " Duplicate product, don't add to sum!");
				else {
					array.add(c);
					System.out.println(a + " x " + b + " = " + c);
				}
			}
		}
		for(int i = 0; i < array.size(); i++)
			sum += array.get(i);
		System.out.println("sum = " + sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
