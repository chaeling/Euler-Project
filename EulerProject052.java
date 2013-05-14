/*
 * Permuted multiples
 * Problem 52
 * 
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, 
 * but in a different order.
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */
package number;

import java.util.HashSet;

public class PermutedMultiples {
  public static HashSet permutedSet(int n){
		HashSet set = new HashSet();
		String str = Integer.toString(n);
		for(int i = 0; i < str.length(); i++)
			set.add(str.charAt(i));
		return set;
	}
	public static boolean isPermutedNum(int n){
		int temp;
		HashSet set = new HashSet();
		HashSet tempSet = new HashSet();
		set = permutedSet(n);
		for(int i = 2; i <= 6; i++){
			temp = n*i;
			tempSet = permutedSet(temp);
			if(!(set.containsAll(tempSet) && tempSet.containsAll(set)))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		int i = 1;
		while(!isPermutedNum(i)){
			i++;
		}
		System.out.println(i);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
