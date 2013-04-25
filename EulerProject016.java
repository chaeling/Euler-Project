/* Power digit sum
 * Problem 16
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */
package number;

import java.math.BigInteger;

public class PowerDigitSum {
  public static int powDigSum(int n){
		BigInteger pow = BigInteger.valueOf(2).pow(n);
		String powToStr = pow.toString();
		int sum = 0;
		for(int i = 0; i < powToStr.length(); i++)
			sum += powToStr.charAt(i) - '0';
		return sum;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(powDigSum(1000));
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
