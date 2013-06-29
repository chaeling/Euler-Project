/*
 * Ordered fractions
 * Problem 71
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper 
 * fraction.

 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

 * It can be seen that 2/5 is the fraction immediately to the left of 3/7.

 * By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending order of size, find the numerator of the 
 * fraction immediately to the left of 3/7.
 */
package number;

public class OrderedFractions {
  public static void main(String[] args) {
		long start = System.nanoTime();
		double f37 = (double) 3 / 7, minDiff = 1;
		int numerator = 0, denominator = 0;
		for(int i = 8; i <= 1000000; i++) {
			if(i % 7 == 0)
				continue;
			double tempDiff = f37 - (double)(i * 3 / 7) / i;
			if(tempDiff < minDiff) {
				minDiff = tempDiff;
				denominator = i;
			}
		}
		numerator = denominator * 3 / 7;
		System.out.println(numerator + "/" + denominator);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
