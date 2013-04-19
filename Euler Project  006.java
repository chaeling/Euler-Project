/* Sum square difference */
/*
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385 The square of the sum of the first
 * ten natural numbers is, (1 + 2 + ... + 10)2 = 552 = 3025 
 * Hence the difference between the sum of the squares of the 
 * first ten natural numbers and the square of the sum is 3025 
 * 385 = 2640.Find the difference between the sum of the squares 
 * of the first one hundred natural numbers and the square of 
 * the sum.
 */
package number;

public class SumSquareDifference {
  /*public static int sum1(int n){
		if(n == 1)
			return n*n;
		else
			return sum1(n-1) + n*n;
	}
	public static int sum2(int n){
		if(n == 1)
			return n*n;
		else
			return n*n*(n+1)*(n+1)/4;
	}*/
	public static int difference(int n){
		int sum = 0;
		for(int i = 1; i <= n; i++){
			for(int j = i+1; j <= n; j++)
				sum += i*j;
		}
		sum *= 2;
		return sum;
	}
	public static void main(String[] args) {
		//System.out.println(sum2(100) - sum1(100));
		System.out.println(difference(100));
	}
}
