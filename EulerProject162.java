/*
 * Hexadecimal numbers
 * Problem 162
 * In the hexadecimal number system numbers are represented using 16 different digits:

 * 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F
 * The hexadecimal number AF when written in the decimal number system equals 10x16+15=175.

 * In the 3-digit hexadecimal numbers 10A, 1A0, A10, and A01 the digits 0,1 and A are all present.
 * Like numbers written in base ten we write hexadecimal numbers without leading zeroes.

 * How many hexadecimal numbers containing at most sixteen hexadecimal digits exist with all of the digits 0,1, 
 * and A present at least once?
 * Give your answer as a hexadecimal number.

 * (A,B,C,D,E and F in upper case, without any leading or trailing code that marks the number as hexadecimal and 
 * without leading zeroes , e.g. 1A3F and not: 1a3f and not 0x1a3f and not $1A3F and not #1A3F and not 0000001A3F)
 */
package number;

import java.math.*;

public class HexadecimalNumbers {
  public static void main(String[] args) {
		long start = System.nanoTime();	
		BigInteger sum = BigInteger.ZERO;
		for(int i = 3; i <= 16; i++) {
			// sum += 15 * 16^(i - 1) - 15^i - 2 * 14 * 15^(i - 1) + 13 * 14^(i - 1) + 2 * 14^i - 13^i;
			BigInteger temp1 = BigInteger.valueOf(15).multiply(BigInteger.valueOf(16).pow(i - 1));
			BigInteger temp2 = BigInteger.valueOf(43).multiply(BigInteger.valueOf(15).pow(i - 1));
			BigInteger temp3 = BigInteger.valueOf(41).multiply(BigInteger.valueOf(14).pow(i - 1));	
			BigInteger temp4 = BigInteger.valueOf(13).pow(i);
			sum = sum.add(temp1).subtract(temp2).add(temp3).subtract(temp4);
		}
		System.out.println(sum.toString(16));
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
