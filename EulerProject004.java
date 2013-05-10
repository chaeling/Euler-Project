/*  Largest palindrome product */
/*
 * A palindromic number reads the same both ways.
 *  The largest palindrome made from the product 
 *  of two 2-digit numbers is 9009 = 91 99.Find 
 *  the largest palindrome made from the product 
 *  of two 3-digit numbers.
 */
package number;

import java.util.ArrayList;
import java.util.Collections;

public class LargestPalindromeNumber {
	/* The first palindrome function is faster than the second. */
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
	}*/
  public static boolean isPalindrome(int n){
		String a = n + "";
		String b = new StringBuilder(a).reverse().toString();
		if(b.equals(a))
			return true;
		else
			return false;
	}
	public static void largestPalindromeNum(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int i, j, result;
		for(i = 999; i >= 100; i--){
			for(j = 999; j >= i; j--){
				result = i * j;
				if(isPalindrome(result))
					arr.add(result);
			}
		}
		System.out.println(Collections.max(arr));
	}
	public static void main(String[] args) {
		largestPalindromeNum();
	}
}

