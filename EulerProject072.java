/*
 * Counting fractions
 * Problem 72
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

 * It can be seen that there are 21 elements in this set.

 * How many elements would be contained in the set of reduced proper fractions for d ≤ 1,000,000?
 */
package number;

public class CountingFractions {
  public static int[] totient(int n) {
		int[] list = new int[n + 1];
		for(int i = 0; i <= n; i++)
			list[i] = i;
		for(int i = 2; i <= n; i++) {
			if(list[i] == i) { // if i is a prime
				for(int j = i; j <= n; j += i)
					list[j] = list[j] / i * (i - 1);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		int[] totient = totient(1000000);
		long count = 0; 
		for(int i = 2; i < totient.length; i++)
			count += totient[i];
		System.out.println(count);
		
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
