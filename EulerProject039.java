/*
 * Integer right triangles
 * Problem 39
 * 
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, 
 * there are exactly three solutions for p = 120.

 * {20,48,52}, {24,45,51}, {30,40,50}

 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
package number;

public class IntegerRightTriangles {
  private static int rightRriangleNum(int n){
		int count = 0;
		for(int a = 1; a < n/3; a++)
			for(int b = a + 1; b < n/2 - 1; b++){
				int c = n - a - b;
				if(a*a + b*b == c*c)
					count++;
			}
		return count;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int max = 0;
		for(int i = 12; i <= 1000; i++)
			if(rightRriangleNum(i) > rightRriangleNum(max))
				max = i;
		System.out.println(max);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
