/* Largest prime factor */
/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 
 * 600851475143 ?
 */
package number;

public class LargestPrimeFactor {
  /*private static boolean isPrime(long n){
		if(n < 2)
			return false;
		else if(n == 2)
			return true;
		else if(n%2 == 0)
			return false;
		else{
			for(long i = 2; i <= java.lang.Math.sqrt(n); i++)
				if(n%i == 0)
					return false;
			return true;
		}
	}
	*/
	public static long largestPrimeFactor(long n){
		int i = 2;
		while(i != n){
			if(n%i == 0)
				n = n/i;
			else 
				i++;
		}
		return n;
	}
	public static void main(String[] args) {
		System.out.println(largestPrimeFactor(600851475143L));
	}
}
