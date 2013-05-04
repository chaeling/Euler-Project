/*
 * Non-abundant sums
 * Problem 23
 * 
 * A perfect number is a number for which the sum of its proper divisors 
 * is exactly equal to the number. For example, the sum of the proper 
 * divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 
 * is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is 
 * less than n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest 
 * number that can be written as the sum of two abundant numbers is 24. By 
 * mathematical analysis, it can be shown that all integers greater than 28123 
 * can be written as the sum of two abundant numbers. However, this upper limit 
 * cannot be reduced any further by analysis even though it is known that the 
 * greatest number that cannot be expressed as the sum of two abundant numbers is 
 * less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum 
 * of two abundant numbers.
 */
package number;

public class NonAbundantSums {
  private static boolean[] num = new boolean[28124];
	public static boolean isAbundant(int n){
		if(n < 12)
			return false;
		else{
			int divSum = 1;
			for(int i = 2; i < Math.sqrt(n); i++)
				if(n%i == 0)
					divSum += i + n/i;
			if(n%Math.sqrt(n) == 0)
				divSum += Math.sqrt(n);
			return divSum > n;
		}	
	}

	public static boolean isSumOfTwoAbundant(int n){
		for(int i = 0; i <= n/2; i++)
			if(num[i] && num[n-i])
				return true;
		return false;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		for(int i = 0; i < num.length; i++)
			num[i] = isAbundant(i);
		int sum = 0;
		for(int i = 0; i <= 28124; i++)
			if(!isSumOfTwoAbundant(i))
				sum += i;
		System.out.println(sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
