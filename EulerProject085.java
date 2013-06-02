/*
 * Counting rectangles
 * Problem 85
 * 
 * By counting carefully it can be seen that a rectangular grid measuring 3 by 2 contains eighteen rectangles:

  http://projecteuler.net/problem=85
	
 * Although there exists no rectangular grid that contains exactly two million rectangles, find the area of the 
 * grid with the nearest solution.
 * 
 */
package number;

public class CountingRectangles {
	public static int rectanglesNum(int m, int n){
		return m * (m + 1) * n * (n + 1) / 4;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		int standard = 2000000;
		int min = standard;
		int m = 0, n = 0;
		for(int i = 1; i <= 53; i++){
			for(int j = i; j <= 2000; j++) {
				if(min > Math.abs(rectanglesNum(i, j) - standard)) {
					m = i;
					n = j;
					min = Math.abs(rectanglesNum(i, j) - standard);
				}
			}
		}
		System.out.println("i = " + m + ", j = " + n + ", area = " + m * n + ", rectanglesNum = " + rectanglesNum(m, n));
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
