/*
 * Champernowne's constant
 * Problem 40
 * 
 * An irrational decimal fraction is created by concatenating the positive integers:

 *                          0.123456789101112131415161718192021...

 * It can be seen that the 12th digit of the fractional part is 1.

 * If dn represents the nth digit of the fractional part, find the value of the following expression.

 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
package number;

public class ChampernownesConstant {
  public static void main(String[] args) {
		long start = System.nanoTime();
		StringBuilder list = new StringBuilder("0123456789");
		int i = 10;
		while(list.length() <= 1000000){
			list.append(Integer.toString(i));
			i++;
		}
		int multiply = (list.charAt(1) - '0') * (list.charAt(10) - '0') * (list.charAt(100) - '0') * 
				(list.charAt(1000) - '0') * (list.charAt(10000) - '0') * (list.charAt(100000) - '0') * 
				(list.charAt(1000000) - '0');
		System.out.println(multiply);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
