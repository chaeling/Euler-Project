/*
 * Counting fractions in a range
 * Problem 73
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a 
 * reduced proper fraction.

 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

 * It can be seen that there are 3 fractions between 1/3 and 1/2.

 * How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?
 */
package number;

public class CountingFractionsInARange {
	public static int sternBrocotCount(int leftN, int leftD, int rightN, int rightD, int limit) {
		int n = leftN + rightN;
		int d = leftD + rightD;
		if(d > limit)
			return 0;
		else
			return 1 + sternBrocotCount(leftN, leftD, n, d, limit) + sternBrocotCount(n, d, rightN, rightD, limit);
	}
		
	/*public static int gcd(int m, int n) {
		if(n == 0)
			return m;
		else
			return gcd(n, m % n);
	}*/
	public static void main(String[] args) {
		long start = System.nanoTime();
		
//		int count = 0;
//		for(int i = 1; i <= 12000; i++) {
//			for(int j = i / 3 + 1; 2 * j < i; j++) 
//				if(gcd(i, j) == 1) 
//					count++;
//		}
//		System.out.println(count);
		
		System.out.println(sternBrocotCount(1, 3, 1, 2, 12000));
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
