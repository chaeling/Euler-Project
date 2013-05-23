/*
 * Square digit chains
 * Problem 92
 * 
 * A number chain is created by continuously adding the square of the digits in a number to form a 
 * new number until it has been seen before.

 * For example,

 * 44 → 32 → 13 → 10 → 1 → 1
 * 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89

 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most 
 * amazing is that EVERY starting number will eventually arrive at 1 or 89.

 * How many starting numbers below ten million will arrive at 89?
 */
package number;

public class SquareDigitChains {
  private static int squareDigitSum(int n){
		int sum = 0;
		for(; n != 0; n /= 10)
			sum += (n % 10) * (n % 10);
		return sum;
	}
	private static int chainEnd(int n){
		int next = 0;
		for(; next != 89 && next != 1; n = next)
			next = squareDigitSum(n);
		return next;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		int count = 0;
		for(int i = 1; i < 10000000; i++)
			if(chainEnd(i) == 89)
				count++;
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
