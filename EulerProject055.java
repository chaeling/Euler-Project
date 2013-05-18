/*
 * Lychrel numbers
 * Problem 55
 * 
 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.

 * Not all numbers produce palindromes so quickly. For example,

 *                  349 + 943 = 1292,
 *                  1292 + 2921 = 4213
 *                  4213 + 3124 = 7337

 * That is, 349 took three iterations to arrive at a palindrome.

 * Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome. 
 * A number that never forms a palindrome through the reverse and add process is called a Lychrel number. Due 
 * to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a 
 * number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand, 
 * it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing 
 * power that exists, has managed so far to map it to a palindrome. In fact, 10677 is the first number to be 
 * shown to require over fifty iterations before producing a palindrome: 4668731596684224866951378664 
 * (53 iterations, 28-digits).

 * Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.

 * How many Lychrel numbers are there below ten-thousand?

 * NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.
 */
package number;

import java.math.BigInteger;

public class LychrelNumbers {
  private static boolean isPalindrome(BigInteger n){
		return n.toString().equals(new StringBuilder(n.toString()).reverse().toString());
	}
	
/*	private static int lychrelNumSteps(int n){
		int step = 0;
		BigInteger temp = BigInteger.valueOf(n);
		while(!isPalindrome(temp)){
			step++;
			temp = temp.add(new BigInteger(new StringBuilder(temp.toString()).reverse().toString()));
		}
		return step;
	}*/
	
	private static boolean isLychrelNum(int n){
		int step = 0;
		BigInteger temp = BigInteger.valueOf(n);
		do{
			step++;
			temp = temp.add(new BigInteger(new StringBuilder(temp.toString()).reverse().toString()));
		}while(!isPalindrome(temp) && step <= 50);
		return step >= 50;
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		int count = 0;
		for(int i = 0; i < 10000; i++)
			if(isLychrelNum(i))
				count++;
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
