/*
 * Concealed Square
 * Problem 206
 * 
 * Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
 * where each “_” is a single digit.
 */
package number;

public class ConcealedSquare {
  public static boolean isFormat(long n){
		return (n % 10 == 0) && (n / 100 % 10 == 9) && (n / 10000 % 10 == 8)
				&& (n / 1000000 % 10 == 7) && (n / 100000000 % 10 == 6) && (n / 10000000000L % 10 == 5)
				&& (n / 1000000000000L % 10 == 4) && (n / 100000000000000L % 10 == 3)
				&& (n / 10000000000000000L % 10 == 2) && (n / 1000000000000000000L % 10 == 1);
	}
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int start = (int)Math.sqrt(1020304050607080900L);
		int end = (int)Math.sqrt(1929394959697989990L);
		
		
		for(int i = start; i <=end; i++) {
			long product = (long)i * (long)i;
			if(isFormat(product))
				System.out.println(i);
		}
		
		long time = System.nanoTime() - startTime;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
