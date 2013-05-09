/*
 * Digit fifth powers
 * Problem 30
 * 
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *                       1634 = 1^4 + 6^4 + 3^4 + 4^4
 *                       8208 = 8^4 + 2^4 + 0^4 + 8^4
 *                       9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 1^4 is not a sum it is not included.
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
package number;

public class DigitFifthPowers {
/*	public static boolean isSumOfPowerDigits(int n){
		String temp = n + "";
		int sum = 0;
		for(int i = 0; i < temp.length(); i++)
			sum += Math.pow(Integer.parseInt(temp.substring(i, i + 1)), 5);
		return  n == sum;
	}*/
	public static boolean isSumOfPowerDigits(int n){ 
		int digit, temp = n, sum = 0;
		while(temp != 0){
			digit = temp%10;
			sum += Math.pow(digit, 5);
			temp /= 10;
		}
		if(n == sum)
			return true;
		return false;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int sum = 0;
		for(int i = 2; i < 1000000; i++)       // Numbers containing more than six digits is larger than 
			if(isSumOfPowerDigits(i))      // the sum of fifth powers of their digits even if all 
				sum += i;              // digits of a number are 9 (9^5 <= (10^n)/n, get n = 6)
		System.out.println(sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
