/*
 * Reciprocal cycles
 * Problem 26
 * 
 * A unit fraction contains 1 in the numerator. The decimal representation of the 
 * unit fractions with denominators 2 to 10 are given:
 *                1/2	= 	0.5
 *                1/3	= 	0.(3)
 *                1/4	= 	0.25
 *                1/5	= 	0.2
 *                1/6	= 	0.1(6)
 *                1/7	= 	0.(142857)
 *                1/8	= 	0.125
 *                1/9	= 	0.(1)
 *                1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen 
 * that 1/7 has a 6-digit recurring cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in 
 * its decimal fraction part.
 */
package number;

import java.util.*;

public class ReciprocalCycles {
/*	public static int recurringLength(int n) {
		List<Integer> list = new LinkedList<Integer>();
		int temp = 10;
		while(!list.contains(temp % n)) {
			list.add(temp % n);
			temp = temp % n * 10;
		}
		return list.size() - list.indexOf(temp % n);
	}*/
	public static void main(String[] args) {
		long start = System.nanoTime();
/*		int count = 1;
		for(int i = 1; i < 1000; i++) 
			count = recurringLength(count) > recurringLength(i) ? count : i;
		System.out.println(count);*/
		
		int len = 0;
		for(int i = 1000; i > 1; i--) {
			if(i <= len)
				break;
			int[] remaider = new int[i];
			int position = 0, value = 1;
			while(remaider[value] == 0 && value != 0) {
				remaider[value] = position;
				value *= 10;
				value %= i;
				position++;
			}
			if(position - remaider[value] > len)
				len = position - remaider[value] + 1;
		}
		System.out.println(len);
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
