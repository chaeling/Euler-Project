/*Number letter counts
 * Problem 17
 * If the numbers 1 to 5 are written out in words: one, two, three, four, 
 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written 
 * out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred 
 * and forty-two) contains 23 letters and 115 (one hundred and fifteen) 
 * contains 20 letters. The use of "and" when writing out numbers is in 
 * compliance with British usage.
 */
package number;

public class NumberLetterCounts {
  static int[] units = {3, 3, 5, 4, 4, 3, 5, 5, 4};          // 1, 2, 3, 4, 5, 6, 7, 8, 9
	static int[] teens = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8};     // 10, 11, 12, 13, 14, 15, 16, 17, 18, 19
	static int[] tys = {6, 6, 5, 5, 5, 7, 6, 6};             // 20, 30, 40, 50, 60, 70, 80, 90
	                                                         // length(hundred) = 7; length(thousand) = 8; length(and) = 3;
	public static int letterCounts(int n){
		// This method is just for number between 1~1000!!!
		int count = 0;
		if(n == 1000)
			count = 11;
		else if(n < 1000){
			if(n/100 > 0)
				count += units[n/100 - 1] + 7;                  // x hundred
			if(n/100 > 0 && n%100 > 0)
				count += 3;                                    // x hundred + "and"
			if(n%100/10 > 1)                                   
				count += (n%100%10 == 0) ? tys[n%100/10 - 2] : (tys[n%100/10 - 2] + units[n%100%10 - 1]);    
			if(n%100/10 == 1)
				count += teens[n%100 - 10];
			if(n%100/10 == 0 && n%100 != 0)
				count += units[n%100 - 1];
		}
		return count;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int sum = 0;
		for(int i = 1; i <= 1000; i++)
			sum += letterCounts(i);
		System.out.println(sum);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
