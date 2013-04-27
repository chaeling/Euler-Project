/*Amicable numbers
 * Problem 21
 */
/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less 
 * than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a  b, then a and b are an amicable 
 * pair and each of a and b are called amicable numbers. For example, 
 * the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 
 * and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 
 * 2, 4, 71 and 142; so d(284) = 220.
 * Evaluate the sum of all the amicable numbers under 10000.
 */
package number;

public class AmicableNumbers {
  public static int factorSum(int n){
		if(n == 1)
			return 0;
		else{
			int sum = 1;
			for(int i = 2; i < Math.sqrt(n); i++)
				if(n%i == 0)
					sum += (i + n/i);
			if(n%Math.sqrt(n) == 0)
				sum += Math.sqrt(n);
			return sum;
		}	
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int sum = 0;
		for(int i = 2; i < 10000; i++)
			if(factorSum(factorSum(i)) == i && i != factorSum(i))
				sum += i;
		System.out.println(sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime = " + time/1000/1000.0 + " ms.");
	}
}
