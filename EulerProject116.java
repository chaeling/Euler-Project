/*
 * Red, green or blue tiles
 * Problem 116
 * URL:http://projecteuler.net/problem=116
 * A row of five black square tiles is to have a number of its tiles replaced with coloured oblong tiles chosen
 *  from red (length two), green (length three), or blue (length four).

 * If red tiles are chosen there are exactly seven ways this can be done.
  	
 * If green tiles are chosen there are three ways.

 * And if blue tiles are chosen there are two ways.
	
 * Assuming that colours cannot be mixed there are 7 + 3 + 2 = 12 ways of replacing the black tiles in a row 
 * measuring five units in length.

 * How many different ways can the black tiles in a row measuring fifty units in length be replaced if colours 
 * cannot be mixed and at least one coloured tile must be used?
 */
package number;

import java.math.BigInteger;

public class RedGreenBlueTiles {
	/*private static BigInteger factorial(int m, int n){
		if(m > n)
			throw new IllegalArgumentException();
		BigInteger value = BigInteger.ONE;
		for(int i = n - m + 1; i <= n; i++)
			value = value.multiply(BigInteger.valueOf(i));
		return value;
	}

	private static BigInteger combination(int m, int n){
		if(m > n)
			throw new IllegalArgumentException();
		return factorial(m, n).divide(factorial(m, m));
	}
	
	public static BigInteger colorTiles(String color, int n) {
		int colorValue;
		BigInteger sum = BigInteger.ZERO;
		switch (color) {
			case "red"   : colorValue = 2;
				break;
			case "green" : colorValue = 3;
				break;
			case "blue"  : colorValue = 4;
				break;
			default      : colorValue = 0;
		}
		int end = n/colorValue;
		for(int i = 1; i <= end; i++){
			sum = sum.add(combination(i, n - colorValue * i + i));
		}		
		return sum;
	}
	public static BigInteger tilesSum(int n) {
		return colorTiles("red", n).add(colorTiles("green", n)).add(colorTiles("blue", n));
	}*/
	
	public static long colorTiles(String color, int n) {
		int colorValue;
		long[] sum = new long[n + 1];
		switch (color) {
			case "red"   : colorValue = 2;
				break;
			case "green" : colorValue = 3;
				break;
			case "blue"  : colorValue = 4;
				break;
			default      : colorValue = 0;
		}
		sum[0] = 1;
		for(int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1];
			if(i >= colorValue)
				sum[i] += sum[i - colorValue];
		}
		return sum[n] - 1; // exclude the all black blocks situation.
	}
	public static long tilesSum(int n) {
		return colorTiles("red", n) + colorTiles("green", n) + colorTiles("blue", n);
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(tilesSum(50));
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
