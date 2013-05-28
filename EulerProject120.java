/*
 * Square remainders
 * Problem 120
 * 
 * Let r be the remainder when (a−1)^n + (a+1)^n is divided by a2.

 * For example, if a = 7 and n = 3, then r = 42: 6^3 + 8^3 = 728 ≡ 42 mod 49. And as n varies, so too 
 * will r, but for a = 7 it turns out that rmax = 42.

 * For 3 ≤ a ≤ 1000, find ∑ rmax.
 */
package number;

public class SquareRemainders {
/*	public static int rMax(int a){
		// (a−1)^n + (a+1)^n = 2 * (0Cn*a^n + 2Cn*a^(n-2) + ... + 2kCn*a^(n-2k))
		//if n is odd, the result is (2*1) % a^2, it's 2; and if n is even, the result will be (2n*a) % a^2, 
		// so let n = (a - 1)/2, we get the max result. (if n is beyond a, it will get the same max result).
		if(a < 3)
			return 2;
		else
			return (2 * ((a - 1)/2) * a) % (a * a); 
	}*/
	
	public static int rMax(int a){
		if(a < 3)
			return 2;
		else
			return a * (a - (a % 2 == 0 ? 2 : 1));
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int sum = 0;
		for(int i = 3; i <= 10000; i++)
			sum += rMax(i);
		System.out.println(sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
