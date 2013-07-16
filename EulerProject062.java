/*
 * Cubic permutations
 * Problem 62
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3). 
 * In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

 * Find the smallest cube for which exactly five permutations of its digits are cube.
 */
package number;

import java.util.*;

public class CubicPermutations {
  public static String permInOrder(long n) {
		char[] temp = Long.toString(n).toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		Map<String, Integer> list = new HashMap<String, Integer>();
		Map<String, Integer> count = new HashMap<String, Integer>();
		
		for(int i = 1; i < 10000; i++) {
			String perm = permInOrder((long) i * i * i);
			
			Integer fList = list.get(perm);
			list.put(perm, (fList == null) ? i : fList);
			
			Integer fCount = count.get(perm);
			count.put(perm, fCount == null ? 1 : fCount + 1);
		}
		
		int min = 10000;
		for(int i = 1; i < 10000; i++) {
			String perm = permInOrder((long) i * i * i);
			if(count.get(perm) == 5) {
				min = Math.min(min, list.get(perm));
				System.out.println(list.get(perm) + " : " + count.get(perm));
			}
		}
		System.out.println(min);
		System.out.println((long) min * min * min);
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
