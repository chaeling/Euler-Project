/*
 * Digit canceling fractions
 * Problem 33
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it 
 * may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing 
 * two digits in the numerator and denominator.

 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
package number;

public class DigitCancelingFractions {
  public static boolean mRnR(int m, int n) {
		return (double) m / n == (double) (m / 10) / (n / 10);
	}
	public static boolean mRnL(int m, int n) {
		return (double) m / n == (double) (m / 10) / (n % 10);
	}
	public static boolean mLnL(int m, int n) {
		return (double) m / n == (double) (m % 10) / (n % 10);
	}
	public static boolean mLnR(int m, int n) {
		return (double) m / n == (double) (m % 10) / (n / 10);
	}
	
	private static int gcd(int m, int n){
		while(n != 0){
			int p = m % n;
			m = n;
			n = p;
		}
		return m;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		int i = 1, j = 1;
		for(int n = 11; n < 100; n++)
			for(int m = 10; m < n; m++) {
//				if((n % 10 == m % 10) && mRnR(m, n))
//					System.out.println("m = " + m + ", n = " + n);
//				if((n % 10 == m / 10) && mLnR(m, n))
//					System.out.println("m = " + m + ", n = " + n);
//				if((n / 10 == m / 10) && mLnL(m, n))
//					System.out.println("m = " + m + ", n = " + n);
				if((n / 10 == m % 10) && mRnL(m, n)) {
					i *= m;
					j *= n;
					System.out.println("m = " + m + ", n = " + n);
				}	
			}
		j /= gcd(i, j);
		System.out.println(j);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
