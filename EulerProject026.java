/*
 * Reciprocal cycles
 * Problem 26
 * 
 * A unit fraction contains 1 in the numerator. The decimal representation of the 
 * unit fractions with denominators 2 to 10 are given:
 *                1/2  = 	0.5
 *                1/3	= 	0.(3)
 *                1/4	= 	0.25
 *                1/5	= 	0.2
 *                1/6	= 	0.1(6)
 *                1/7	= 	0.(142857)
 *                1/8	= 	0.125
 *                1/9	= 	0.(1)
 *                1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen 
 * that 1/7 has a 6-digit recurring cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in 
 * its decimal fraction part.
 */
package number;

public class ReciprocalCycles {
	public static boolean isPrime(int n){
		if(n < 10){
			if(n == 2 || n == 3 || n == 5 || n == 7)
				return true;
		}else{
			if(n%2 != 0){
				for(int i = 3; i <= Math.sqrt(n); i += 2)
					if(n%i == 0)
						return false;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int max = 0;
		for(int i = 1; i < 1000; i++)
			if(isPrime(i))
				max = i;
		System.out.println(max);
	}
}
