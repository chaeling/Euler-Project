/*
 * Quadratic primes
 * Problem 27
 * 
 * Euler published the remarkable quadratic formula:
 *                                             n² + n + 41
 * It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. 
 * However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when 
 * n = 41, 41² + 41 + 41 is clearly divisible by 41.
 * 
 * Using computers, the incredible formula  n² - 79n + 1601 was discovered, which produces 80 primes 
 * for the consecutive values n = 0 to 79. The product of the coefficients, -79 and 1601, is -126479.
 * 
 * Considering quadratics of the form:
 * n² + an + b, where |a| < 1000 and |b| < 1000
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |4| = 4
 * 
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the 
 * maximum number of primes for consecutive values of n, starting with n = 0.
 */
package number;

public class QuadraticPrimes {
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
	public static int primeNumCount(int a, int b){
		int count = 0, i = 0;
		while(isPrime(i*i + a*i + b)){
			count++;
			i++;
		}
		return count;	
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int coeA = 0, coeB = 0, maxChain = 0;
		for(int a = -999; a <= 999; a++)
			for(int b = -999; b <= 999; b++){
				if(maxChain < primeNumCount(a, b)){
					maxChain = primeNumCount(a, b);
					coeA = a;
					coeB = b;
				}
			}
		System.out.println("maxChain = " + maxChain);
		System.out.println("a = " + coeA + "  b = " + coeB);
		System.out.println("Coefficients = " + coeA*coeB);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
