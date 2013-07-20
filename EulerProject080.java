/*
 * Square root digital expansion
 * Problem 80
 * It is well known that if the square root of a natural number is not an integer, then it is irrational. The decimal 
 * expansion of such square roots is infinite without any repeating pattern at all.

 * The square root of two is 1.41421356237309504880..., and the digital sum of the first one hundred decimal digits is 475.

 * For the first one hundred natural numbers, find the total of the digital sums of the first one hundred decimal digits 
 * for all the irrational square roots.
 */
package number;

import java.math.BigInteger;

public class SquareRootDigitalExpansion {
  public static String sqrt(int n, int digits) {
		//reference --- http://en.wikipedia.org/wiki/Methods_of_computing_square_roots
		//结果未进行四舍五入
		String number = "";
		String result = "";
		BigInteger tempDiff;
		BigInteger nextProduct;
		int len = Integer.toString(n).length();
		int cursor;
		int product;
		if(digits < len / 2 + len % 2)
			throw new IllegalArgumentException("digits couldn't be less than " + (len / 2 + len % 2));
		if(len % 2 == 1) {
			number = BigInteger.valueOf(n).multiply(BigInteger.valueOf(10).pow(2 * digits - len - 1)).toString();
			cursor = 1;
		} else {
			number = BigInteger.valueOf(n).multiply(BigInteger.valueOf(10).pow(2 * digits - len)).toString();
			cursor = 2;
		}
		product = Integer.parseInt(number.substring(0, cursor));
		int divResult = (int) Math.sqrt(product);
		result += divResult;
		tempDiff = BigInteger.valueOf(product - divResult * divResult);

		for(; cursor <= number.length() - 2; cursor += 2) {
			nextProduct = new BigInteger(tempDiff + number.substring(cursor, cursor + 2));
			// get the largest x ---- x * (x + 20 * result) <= nextProduct;
			long i = 0; 
			while(BigInteger.valueOf(i * i).add(new BigInteger(result).multiply(BigInteger.valueOf(20 * i))).compareTo(nextProduct) <= 0)
				i++;
			i--;
			
			tempDiff = nextProduct.subtract(BigInteger.valueOf(i * i).add(new BigInteger(result).multiply(BigInteger.valueOf(20 * i))));
			result += i;	
		}
//		if(digits == (len / 2 + len % 2))
//			result = result.substring(0, len / 2 + len % 2);
//		else
//			result = result.substring(0, len / 2 + len % 2) + "." + result.substring(len / 2 + len % 2, result.length());
//		System.out.println("resutl length = " + result.length());
		return result;
	}
	
	public static int digitsSum(int n) {
		String s = sqrt(n, 100);
		int sum = 0;
		for(int i = 0; i < s.length(); i++)
			sum += s.charAt(i) - '0';
		return sum;
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		long sum = 0; 
		for(int i = 1; i <= 100; i++) {
			if(Math.sqrt(i) != (int) Math.sqrt(i))
				sum += digitsSum(i);
		}
		System.out.println(sum);
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
