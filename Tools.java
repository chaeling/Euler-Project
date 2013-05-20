package number;

import java.util.ArrayList;
import java.math.BigInteger;

public class Tools {
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
	
	private static int gcd(int m, int n){
		while(n != 0){
			int p = m % n;
			m = n;
			n = p;
		}
		return m;
	}
	
	private static long lcm(int m, int n){
		return ((long)m*n)/gcd(m,n);
	}
	
	public static boolean isPalindrome(String s){
		return s.equals(new StringBuilder(s).reverse().toString());
	}
	
	private static boolean isPalindrome(BigInteger n){
		return n.toString().equals(new StringBuilder(n.toString()).reverse().toString());
	}
	
	public static boolean isPalindrome(int n){
		int temp = n, digit, rev = 0;
		while(temp != 0){
			digit = temp % 10;
			rev = rev * 10 + digit;
			temp /= 10;
		}
		return rev == n;
	}
	
	public static int primesFactorNum(int n){
		int count = 0;
		int end = (int) Math.sqrt(n);
		for(int i = 2; i <= end; i++)
			if(n % i == 0){
				while(n % i == 0)
					n /= i;
				end = (int) Math.sqrt(n);
				count++;
			}
		if(n > 1)
			count++;
		return count;
	}
	
	private static ArrayList<String> permutations(String s){
		ArrayList<String> list = new ArrayList<String>();
		permutations(list, "", s);
		return list;
	}
	private static void permutations(ArrayList<String> list, String prefix, String s) {
		int len = s.length();
		if(len == 0)
			list.add(prefix);
		else{
			for(int i = 0; i < len; i++)
				permutations(list, prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, len));
		}
	}
	
	
	private static BigInteger factorial(int n){
		BigInteger value = BigInteger.ONE;
		for(int i = 2; i <= n; i++)
			value = value.multiply(BigInteger.valueOf(i));
		return value;
	}
	private static BigInteger factorial(int m, int n){
		if(m > n)
			throw new IllegalArgumentException();
		BigInteger value = BigInteger.ONE;
		for(int i = n - m + 1; i <= n; i++)
			value = value.multiply(BigInteger.valueOf(i));
		return value;
	}
	
	private static BigInteger combination(int m, int n){
		if(m > n)
			throw new IllegalArgumentException();
		return factorial(m, n).divide(factorial(m, m));
	}
}
