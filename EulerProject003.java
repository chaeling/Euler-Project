/* Largest prime factor */
/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 
 * 600851475143 ?
 */
package number;

public class LargestPrimeFactor {
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
