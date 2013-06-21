package number;

import java.util.ArrayList;
import java.math.BigInteger;

public class Tools {
	public static boolean isPrime(int n) {
		if(n < 0)
			throw new IllegalArgumentException("Negative number");
		if(n == 0 || n == 1)
			return false;
		if(n % 2 == 0 || n % 3 == 0 || n % 5 == 0)
			return n == 2 || n == 3 || n == 5;
		for(int i = 7; i * i <= n; i += 2)
				if(n % i == 0)
					return false;
		return true;
	}
	
	private static boolean[] isPrime(int n) {//Sieve of Eratosthenes: http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
		if(n < 0)
			throw new IllegalArgumentException("Negative number");
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i = 2; i * i <= n; i++)
			for(int j = i; j * i <= n; j++)
				prime[i * j] = false;
		return prime;
	}
	
	private static long[] primeArray(int n){
		if(n < 0)
			throw new IllegalArgumentException("Negative number");
		boolean[] prime = new boolean[n + 1];
		prime[0] = prime[1] = false;
		for(int i = 2; i <= n; i++)
			prime[i] = true;
		for(int i = 2; i * i <= n; i++)
			if(prime[i]) {
				for(int j = i * i; j <= n; j += i) 
					prime[j] = false;
			}
		int count = 0;
		
		for(int i = 0; i <= n; i++)
			if(prime[i])
				count++;
		long[] array = new long[count];
		int j = 0;
		for(int i = 0; i <= n; i++) {
			if(prime[i]) {
				array[j] = i;
				j++;
			}
		}
		return array;
	}
	
	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		else
			return gcd(b, a % b);
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
	
	
	public static BigInteger factorial(int n) {
//		return n == 1 ? BigInteger.ONE : BigInteger.valueOf(n).multiply(factorial(n - 1));
		if(n == 1)
			return BigInteger.ONE;
		else
			return BigInteger.valueOf(n).multiply(factorial(n - 1));
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
	
	// Euler's totient function
	// http://en.wikipedia.org/wiki/Totient
	private static int totient(int n){
		int count = 1;
		for(int i = 2, end = (int) Math.sqrt(n); i <= end; i++){
			if(n % i == 0){
				count *= i - 1;
				n /= i;
				while(n % i == 0){
					count *= i;
					n /= i;
				}
				end = (int) Math.sqrt(n); // This line is not necessary, but it can accelerate the speed.
			}
		}
		if(n != 1)
			count *= n - 1;
		return count;
	}
	
	public static int[] divisorsNum(int n){ // save the divisors number of each number less or equal to n in a array.
		int[] array = new int[n + 1];
		Arrays.fill(array, 2);
		for(int i = 2; i <= Math.sqrt(n); i++) {
			int j = i * i;
			array[j]--;
			while(j < n) {
				array[j] += 2;
				j += i;
			}
		}
		return array;
	}
	
	public static boolean isPandigital(int n) {
		int len = Integer.toString(n).length();
		String pandital = null;
		switch (len) {
			case 1 : pandital = "1";
				break;
			case 2 : pandital = "12";
				break;
			case 3 : pandital = "123";
				break;
			case 4 : pandital = "1234";
				break;
			case 5 : pandital = "12345";
				break;
			case 6 : pandital = "123456";
				break;
			case 7 : pandital = "1234567";
				break;
			case 8 : pandital = "12345678";
				break;
			case 9 : pandital = "123456789";
				break;
			default : break;
		}
		char[] temp = Integer.toString(n).toCharArray();
		Arrays.sort(temp);
		return new String(temp).equals(pandital);
	}
}
