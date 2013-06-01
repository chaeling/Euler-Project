/*
 * Bouncy numbers
 * Problem 112
 * 
 * Working from left-to-right if no digit is exceeded by the digit to its left it is called an increasing number; 
 * for example, 134468.

 * Similarly if no digit is exceeded by the digit to its right it is called a decreasing number; for example, 66420.

 * We shall call a positive integer that is neither increasing nor decreasing a "bouncy" number; 
 * for example, 155349.

 * Clearly there cannot be any bouncy numbers below one-hundred, but just over half of the numbers below one-thousand (525) 
 * are bouncy. In fact, the least number for which the proportion of bouncy numbers first reaches 50% is 538.

 * Surprisingly, bouncy numbers become more and more common and by the time we reach 21780 the proportion of bouncy numbers 
 * is equal to 90%.

 * Find the least number for which the proportion of bouncy numbers is exactly 99%.
 */
package number;

public class BouncyNumbers {
  private static boolean isIncreasingNum(int n){
		for(; n != 0; n /= 10){
			if(n % 10 < n/10 % 10)
				return false;
		}
		return true;
	}
	private static boolean isDecreasingNum(int n){
		for(; n > 10; n /= 10){
			if(n % 10 > n/10 % 10)
				return false;
		}
		return true;
	}
	private static boolean isBouncyNum(int n){
		if(n < 100)
			return false;
		return !isIncreasingNum(n) && !isDecreasingNum(n);
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		int count = 0, i = 0;
		int rate = 0;
		for(i = 1; rate != 99; i++){
			if(isBouncyNum(i))
				count++;
			rate = 100 * count/i;
		}
		i--;
		System.out.println("i = " + i);
		System.out.println((float)count/i);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
