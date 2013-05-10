/*
 * Double-base palindromes
 * Problem 36
 * 
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
package number;

public class DoubleBasePalindromes {
  /*public static boolean isPalindrome(int n){
		int temp = n, digit, rev = 0;
		while(temp != 0){
			digit = temp % 10;
			rev = rev * 10 + digit;
			temp /= 10;
		}
		if(rev == n)
			return true;
		return false;
	}
	public static boolean isDoublePalindrome(int n){
		String bin = Integer.toBinaryString(n);
		String binRev = new StringBuilder(bin).reverse().toString();
		return isPalindrome(n) && bin.equals(binRev);
	}*/
	public static boolean isPalindrome(String s){
		return s.equals(new StringBuilder(s).reverse().toString());
	}
	public static boolean isDoublePalindrome(int n){
		return (isPalindrome(Integer.toString(n)) && isPalindrome(Integer.toString(n, 2)));
	}
	public static void main(String args[]){
		long start = System.nanoTime();
		int sum = 0;
		for(int i = 0; i < 1000000; i++)
			if(isDoublePalindrome(i))
				sum += i;
		System.out.println(sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
