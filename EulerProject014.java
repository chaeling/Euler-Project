/* Longest Collatz sequence */
/*Problem 14
 * The following iterative sequence is defined for the set of positive integers:
 *          n -> n/2 (n is even)
 *          n -> 3n + 1 (n is odd) 
 * Using the rule above and starting with 13, we generate the following sequence:
 *               13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 
 * 10 terms. Although it has not been proved yet (Collatz Problem), it is thought 
 * that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
package number;

import java.util.LinkedList;

public class LongestCollatzSequence {
  public static int collatzNum(int n){
		LinkedList<Long> list = new LinkedList<Long>();
		long length = 0;
		int output = 0;
		for(int i = 10; i <= n; i++){
			long j = (long) i;
			while(j != 1){
				if(j%2 == 0){
					j /= 2;
					list.add(j);
				}else{
					j = 3*j + 1;
					list.add(j);
				}
			}
			if(length < list.size()){
				length = list.size();
				output = i;
			}
			list.clear();
		}
		return output;
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(collatzNum(1000000));
		long end = System.currentTimeMillis();
		System.out.println("Running time is " + (end - start) + " ms");
	}
}
