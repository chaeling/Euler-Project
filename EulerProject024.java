/*
 * Lexicographic permutations
 * Problem 24
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation 
 * of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, 
 * we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

 *                               012   021   102   120   201   210

 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
package number;

import java.util.ArrayList;

public class LexicographicPermutations {
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
		System.out.println(permutations("0123456789").get(999999));
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
