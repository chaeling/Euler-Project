/*
 * Digit factorial chains
 * Problem 74
 * 
 * The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:

 * 1! + 4! + 5! = 1 + 24 + 120 = 145

 * Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it 
 * turns out that there are only three such loops that exist:

 *       169 → 363601 → 1454 → 169
 *       871 → 45361 → 871
 *       872 → 45362 → 872

 * It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,

 *       69 → 363600 → 1454 → 169 → 363601 (→ 1454)
 *       78 → 45360 → 871 → 45361 (→ 871)
 *       540 → 145 (→ 145)

 * Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a 
 * starting number below one million is sixty terms.

 * How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
 */
package number;

import java.util.*;

public class DigitFactorialChains {
  final static int[] DIGIT_FAC = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	private static int facDigitSum(int n){
		int sum = 0;
		for(; n != 0; n /= 10)
			sum += DIGIT_FAC[n % 10];
		return sum;
	}
	private static int chainLength(int n){
		Set<Integer> chain = new HashSet<Integer>();
		int next = n;
		while(!chain.contains(next)){
			chain.add(next);
			next = facDigitSum(next);
		}
		return chain.size();
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		int count = 0;
		for(int i = 0; i < 1000000; i++)
			if(chainLength(i) == 60)
				count++;
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
