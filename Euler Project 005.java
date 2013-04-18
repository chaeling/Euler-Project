/* Smallest multiple */
/*
 * 2520 is the smallest number that can be divided by each
 *  of the numbers from 1 to 10 without any remainder.What 
 *  is the smallest positive number that is evenly divisible 
 *  by all of the numbers from 1 to 20?
 */
package number;

public class SmallestMultiple {
  public static int gcd(int m, int n){
		if(n>m){
			int temp = m;
			m = n;
			n = temp;
		}
		int gcdNum = m;
		while(m != 0){
			m = gcdNum%n;
			gcdNum = n;
			n = m;
		}
		return gcdNum;
	}
	private static int lcm(int m, int n){
		return m*n/gcd(m,n);
	}
	static int multiple(int start, int end){
		if(start > end){
			int temp = end;
			end = start;
			start = temp;
		}
		else if(start == end)
			return start;
		else
			return lcm(end, multiple(start, end-1));
		return multiple(start, end);
	}
	public static void main(String[] args) {
		//System.out.println(multiple(11,19));
		int i = 1;
		boolean flag = false;
		for(i = 1; !flag; i++)
			if(i%11 == 0 && i%13 == 0 && i%14 == 0 && i%15 == 0 && i%16 == 0 && i%17 == 0 && i%18 == 0 && i%19 == 0)
				flag = (i%11 == 0 && i%13 == 0 && i%14 == 0 && i%15 == 0 && i%16 == 0 && i%17 == 0 && i%18 == 0 && i%19 == 0);
		System.out.println(i-1);		
	}
}
