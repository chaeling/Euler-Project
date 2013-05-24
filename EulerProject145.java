/*
 * How many reversible numbers are there below one-billion?
 * Problem 145
 * 
 * Some positive integers n have the property that the sum [ n + reverse(n) ] consists entirely of odd (decimal) 
 * digits. For instance, 36 + 63 = 99 and 409 + 904 = 1313. We will call such numbers reversible; so 36, 63, 409, 
 * and 904 are reversible. Leading zeroes are not allowed in either n or reverse(n).

 * There are 120 reversible numbers below one-thousand.

 * How many reversible numbers are there below one-billion (10^9)?
 */
package number;

public class ReversibleNumbers {
  private static boolean isReversible(long n){
		if(n % 10 == 0)
			return false;
		int digit = 1;
		String s = Long.toString(n);
		int len = s.length();
		for(int i = 0; i < len; i++){
			digit = s.charAt(i) - '0' + s.charAt(len - 1 - i) - '0' + digit/10;
			if(digit % 2 == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int count = 0;
		for(int i = 0; i < 1000000000; i++)
			if(isReversible(i))
				count++;
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
