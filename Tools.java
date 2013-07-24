package number;

import java.util.*;
import java.math.*;

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
	
	private static boolean[] isPrime(int n) {
		//Sieve of Eratosthenes: http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
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
		// This function is to get a prime array whose largest element doesn't exceed the input number n.
		if(n <= 0)
			throw new IllegalArgumentException("Please input a positive number!");
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
		if(n < 0)
			throw new IllegalArgumentException("negative number");
//		return n == 1 || n == 0 ? BigInteger.ONE : BigInteger.valueOf(n).multiply(factorial(n - 1));
		if(n == 1 || n == 0)
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
	
	public static int[] totient(int n) {
		int[] list = new int[n + 1];
		for(int i = 0; i <= n; i++)
			list[i] = i;
		for(int i = 2; i <= n; i++) {
			if(list[i] == i) { // if i is a prime
				for(int j = i; j <= n; j += i)
					list[j] = list[j] / i * (i - 1);
			}
		}
		return list;
	}
	
	public static boolean hasSameDigits(int m, int n) {
		char[] array1 = Integer.toString(m).toCharArray();
		char[] array2 = Integer.toString(n).toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		return Arrays.equals(array1, array2);
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
	
	public static boolean isPandigital(int n) {// test if a number is 1~9 pandigital.
		if(n < 123456789)
			return false;
		char[] temp = Integer.toString(n).toCharArray();
		Arrays.sort(temp);
		return new String(temp).equals("123456789");
	}
	
	public static boolean isPandigital(long n) {// test if a number is 1~9 pandigital.
		boolean[] digital = new boolean[10];
		for(int i = 0; i < 9; i++) {
			if(digital[(int) (n % 10)])
				return false;
			digital[(int) (n % 10)] = true;
			n /= 10;
		}
		return !digital[0];
	}
	
	public static boolean isPentagonal(int n) {
		//Triangle	 	Tn=n(n+1)/2	 	        1, 3, 6, 10, 15, ...
		//Pentagonal	 	Pn=n(3n−1)/2	        	1, 5, 12, 22, 35, ...
		//Hexagonal	 	Hn=n(2n−1)	 	        1, 6, 15, 28, 45, ...
		//This function is to check if a number is pentagonal. It's same with triangle and hexagonal number.
		
		//double inverse = Math.sqrt(24 * n + 1) + 1;
		//return inverse % 6 == 0;
		double inverse = (Math.sqrt(24 * n + 1) + 1) / 6; // faster than the above;
		return inverse == (int) inverse;
	}
	
	public static int sternBrocotCount(int leftN, int leftD, int rightN, int rightD, int limit) {
		int n = leftN + rightN;
		int d = leftD + rightD;
		if(d > limit)
			return 0;
		else
			return 1 + sternBrocotCount(leftN, leftD, n, d, limit) + sternBrocotCount(n, d, rightN, rightD, limit);
	}
	
	public static String sqrt(int n, int digits) {
		//reference --- http://en.wikipedia.org/wiki/Methods_of_computing_square_roots
		//结果未进行四舍五入
		String number = "";
		String result = "";
		BigInteger tempDiff;
		BigInteger nextProduct;
		int len = Integer.toString(n).length();
		int cursor;
		int product;
		if(digits < len / 2 + len % 2)
			throw new IllegalArgumentException("digits couldn't be less than " + (len / 2 + len % 2));
		if(len % 2 == 1) {
			number = BigInteger.valueOf(n).multiply(BigInteger.valueOf(10).pow(2 * digits - len - 1)).toString();
			cursor = 1;
		} else {
			number = BigInteger.valueOf(n).multiply(BigInteger.valueOf(10).pow(2 * digits - len)).toString();
			cursor = 2;
		}
		product = Integer.parseInt(number.substring(0, cursor));
		int divResult = (int) Math.sqrt(product);
		result += divResult;
		tempDiff = BigInteger.valueOf(product - divResult * divResult);

		for(; cursor <= number.length() - 2; cursor += 2) {
			nextProduct = new BigInteger(tempDiff + number.substring(cursor, cursor + 2));
			// get the largest x ---- x * (x + 20 * result) <= nextProduct;
			long i = 0; 
			while(BigInteger.valueOf(i * i).add(new BigInteger(result).multiply(BigInteger.valueOf(20 * i))).compareTo(nextProduct) <= 0)
				i++;
			i--;
			
			tempDiff = nextProduct.subtract(BigInteger.valueOf(i * i).add(new BigInteger(result).multiply(BigInteger.valueOf(20 * i))));
			result += i;	
		}
		if(digits == (len / 2 + len % 2))
			result = result.substring(0, len / 2 + len % 2);
		else
			result = result.substring(0, len / 2 + len % 2) + "." + result.substring(len / 2 + len % 2, result.length());
		return result;
	}
	
	public static int maxSubstringSum(int[] array) {
		//This method makes sense only if there are negative numbers in the array. So we can check that case before use it.
		int maxSum = 0, tempSum = 0;
		for(int i = 0; i < array.length; i++) {
			tempSum += array[i];
			if(tempSum > maxSum)
				maxSum = tempSum;
			else
				if(tempSum < 0)
					tempSum = 0;
		}
		return maxSum;
	}
	
	public static void maxSubstringSum(int[] array) {
		int maxSum = 0, tempSum = 0;
		int leftEnd = 0, rightEnd = 0, tempLeftEnd = 0;
		for(int i = 0; i < array.length; i++){
			if(tempSum == 0)
				tempLeftEnd = i;
			tempSum += array[i];
			if(tempSum > maxSum) {
				maxSum = tempSum;
				leftEnd = tempLeftEnd;
				rightEnd = i;
			}
			else if(tempSum < 0)
				tempSum = 0;
		}
		System.out.println(maxSum + " " + leftEnd + " " + rightEnd);
	}
}
