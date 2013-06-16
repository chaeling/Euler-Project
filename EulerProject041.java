/*
 * Pandigital prime
 * Problem 41
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 
 * 2143 is a 4-digit pandigital and is also prime.

 * What is the largest n-digit pandigital prime that exists?
 */
package number;

import java.util.*;

public class PandigitalPrime {
  public static boolean isPrime(int n) {
		if(n < 0)
			throw new IllegalArgumentException("Negative number");
		if(n == 0 || n == 1)
			return false;
		if(n % 2 == 0 || n % 3 == 0 || n % 5 == 0)
			return n == 2 || n == 3 || n == 5;
		for(int i = 7; i * i <= n; i += 2)
				if(n % i == 0)
					return false;
		return true;
	}
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
		ArrayList<String> list = permutations("1234567");
		int i = list.size() - 1;
		while(!isPrime(Integer.valueOf(list.get(i).toString()))) {
			i--;
		}
		System.out.println(list.get(i));
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
