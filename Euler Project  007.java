/* 10001st prime */
/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, 
 * and 13, we can see that the 6th prime is 13.What is the 
 * 10 001st prime number?
 */
package number;

import java.util.ArrayList;

public class The10001stPrime {
  private static boolean isPrime(long n){
		long n_sqrt = (long) java.lang.Math.sqrt(n);
		for(long i = 2; i <= n_sqrt; i++)
			if(n%i == 0)
				return false;
		return true;
	}
	public static int nthPrime(int n){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 2; arr.size() <= 10001; i++){
			if(isPrime(i))
				arr.add(i);
		}
		return (int) arr.get(n-1);
	}
	public static void main(String[] args) {
		System.out.println(nthPrime(10001));
	}
}
