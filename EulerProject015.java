/* Lattice paths
 * Problem 15
 */
/*
 * Starting in the top left corner of a 2×2 grid, and only being able 
 * to move to the right and down, there are exactly 6 routes to the 
 * bottom right corner.
 * 
 * See picture in : http://projecteuler.net/problem=15
 * How many such routes are there through a 20×20 grid?
 */
package number;

public class LatticePaths {
  public static double permutation(int m, int n){
		if(m > n)
			return 0;
		else if(m == 1)
			return n;
		else
			return n*permutation(m - 1, n - 1);
	}
	public static long combination(int m, int n){
		double a = permutation(m, n);
		double b = permutation(m, m);
		if(m > n)
			return 0;
		else 
			return (long) (a/b);
	}
	public static void main(String[] args) {
		System.out.println(combination(20, 40));
	}
}
