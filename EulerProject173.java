/*
 * Using up to one million tiles how many different "hollow" square laminae can be formed?
 * Problem 173
 * http://projecteuler.net/problem=173
 * We shall define a square lamina to be a square outline with a square "hole" so that the 
 * shape possesses vertical and horizontal symmetry. For example, using exactly thirty-two 
 * square tiles we can form two different square laminae:


 * With one-hundred tiles, and not necessarily using all of the tiles at one time, it is 
 * possible to form forty-one different square laminae.

 * Using up to one million tiles how many different square laminae can be formed?
 */
package number;

public class UsingUpToOneMillionTiles {
  public static int laminaeNumber(int n) {
		int[] laminae1 = new int[n / 8];
		for(int i = 0; i < laminae1.length; i++)
			laminae1[i] = 8 * (i + 1);
		int count = 0;
		for(int i = 0; i < laminae1.length; i++) {
			int sum = 0; 
			for(int j = i; j < laminae1.length; j++) {
				sum += laminae1[j];
				if(sum <= n)
					count++;
				else
					break;
			}
		}
		
		int[] laminae2 = new int[(n + 4) / 8];
		for(int i = 0; i < laminae2.length; i++) 
			laminae2[i] = 8 * (i + 1) - 4;
		for(int i = 1; i < laminae2.length; i++) {
			int sum = 0;
			for(int j = i; j < laminae2.length; j++) {
				sum += laminae2[j];
				if(sum <= n)
					count++;
				else
					break;
			}
		}
		return count;
	}
  
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(laminaeNumber(1000000));
		System.out.println("Runtime is " + (System.nanoTime() - start) / 1000 / 1000.0 + " ms.");
	}
}
