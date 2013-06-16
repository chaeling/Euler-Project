/*
 * Pandigital multiples
 * Problem 38
 * Take the number 192 and multiply it by each of 1, 2, and 3:

 *                      192 × 1 = 192
 *                      192 × 2 = 384
 *                      192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated 
 * product of 192 and (1,2,3)

 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, 
 * which is the concatenated product of 9 and (1,2,3,4,5).

 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer 
 * with (1,2, ... , n) where n > 1?
 */
package number;

import java.util.Arrays;

public class PandigitalMultiples {
  public static boolean isPandigitalMultiple(int n) {
		int i = 1;
		String multiple2Str = Integer.toString(n);
		char[] temp = multiple2Str.toCharArray();
		while(!new String(temp).equals("123456789")) {
			i++;
			multiple2Str += n * i;
			temp = multiple2Str.toCharArray();
			Arrays.sort(temp);
			if(i > 9)
				return false;
		}
		System.out.println(n + "  (1~" + i + ")");
		System.out.println(multiple2Str);
		return true;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		for(int i = 1; i <= 10000; i++)
			if(isPandigitalMultiple(i))
				System.out.println();
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
