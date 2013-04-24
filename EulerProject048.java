/* Self powers */
/*
 * Problem 48
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
package number;

import java.math.BigInteger;

public class SelfPowers {
  public static BigInteger selfPowerSum(int n){
		BigInteger sum = BigInteger.ZERO;
		for(int i = 1; i <= n; i++)
			sum = sum.add(BigInteger.valueOf(i).pow(i));
		return sum;
	}
	public static void main(String[] args) {
		String str = selfPowerSum(1000).toString();
		System.out.println(str.substring(str.length()-10, str.length()));
	}
}
