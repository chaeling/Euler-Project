/* Factorial digit sum
 * Problem 20
 */
/*
 * n! means n x (n - 1) x... x 3 x 2 x 1 
 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 */
package number;

import java.math.BigInteger;

public class FactorialDigitSum {
  public static BigInteger factorial(int n){
		BigInteger product = BigInteger.valueOf(1);
		if(n < 0)
			throw new IllegalArgumentException("Factorial of negative number");
		for(int i = 1; i <= n; i++)
			product = product.multiply(BigInteger.valueOf(i));
		return product;
	}
	public static int digitSum(int n){
		String strFactorial = factorial(n).toString();
		int sum = 0;
		for(int i = 0; i < strFactorial.length(); i++)
			sum += strFactorial.charAt(i) - '0';
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(digitSum(100));
	}
}
