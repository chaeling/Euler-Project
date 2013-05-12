/*
 * Number spiral diagonals
 * Problem 28
 * 
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

*                                    21 22 23 24 25
*                                    20  7  8  9 10
*                                    19  6  1  2 11
*                                    18  5  4  3 12
*                                    17 16 15 14 13

* It can be verified that the sum of the numbers on the diagonals is 101.

* What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
package number;

public class NumberSpiralDiagonals {
  public static long f(int n){
		if(n == 1)
			return 1;
		else
			return 4*n*n - 6*n + 6;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		long sum = 0;
		for(int i = 1; i <= 1001; i += 2)
			sum += f(i);
		System.out.println(sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
