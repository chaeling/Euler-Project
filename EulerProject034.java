/*
 * Digit factorials
 * Problem 34
 *
 *145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *Find the sum of all numbers which are equal to the sum of the 
 *factorial of their digits.
 *Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
package number;

public class DigitFactorials {
/*  public static long factorial(int n){
		if(n < 0 | n > 9)
			throw new IllegalArgumentException("Exceed of number range");
		else{
			if(n == 0 | n == 1)
				return 1;
			else
				return n*factorial(n-1);
		}
	}
	public static int digitFactorialSum(int n){
		String str = Integer.toString(n);
		int digFacSum = 0;
		for(int i = 0; i < str.length(); i++)
			digFacSum += factorial(Integer.parseInt(str.charAt(i) + ""));
		return digFacSum;
	}*/
	private static int[] FACTORIAL = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	public static int digitFactorialSum(int n){
		int sum = 0;
		while(n != 0){
			sum += FACTORIAL[n%10];
			n = n/10;
		}
		return sum;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		// if a number has 8 or more digits, even if all digits are 9, the 
		//sum of digit factorial is less than the number.
		for(int i = 10; i < 10000000; i++){
			if(i == digitFactorialSum(i))
				System.out.println(i);
		}	
		long time = System.nanoTime() - start;
		System.out.println("Runtime = " + time/1000/1000.0+ " ms.");
	}
}
