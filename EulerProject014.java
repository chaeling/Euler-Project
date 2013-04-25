/* Longest Collatz sequence */
/*Problem 14
 * The following iterative sequence is defined for the set of positive integers:
 *          n -> n/2 (n is even)
 *          n -> 3n + 1 (n is odd) 
 * Using the rule above and starting with 13, we generate the following sequence:
 *               13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 
 * 10 terms. Although it has not been proved yet (Collatz Problem), it is thought 
 * that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
package number;

public class LongestCollatzSequence {
/*	public static long collatzNum(long n){
        long count = 0;
        while(n != 1){
            if(n%2 == 0)
                n = n/2;
            else 
                n = 3*n + 1;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
    	long start = System.currentTimeMillis();
        int max = 0;
        long maxChainNum = 0;
        for(int i = 10; i <= 1000000; i++){
            if(collatzNum(i) > maxChainNum){
            	max = i;
            	maxChainNum = collatzNum(max);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(max);
        System.out.println(maxChainNum);
        System.out.println("Runnig time is " + (end - start) + " ms");
    }*/
	static final short[] cache = new short[1000000];
	public static int collatzNum(long n){
		if(n == 1)
			return 1;
		if(n < 1000000){
			int count = cache[(int) n];
			if(count > 0)
				return count;
		}
		int next = (n & 1) == 0 ? 1 + collatzNum(n >> 1) : 2 + collatzNum((3*n + 1) >> 1);
		if(n < cache.length)
			cache[(int) n] = (short) next;
		return next;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int maxCount = 0, max = 0;
		for(int i = 1; i < 1000000; i++){
			int count = collatzNum(i);
			if(count > maxCount){
				maxCount = count; 
				max = i;
			}
		}
		long time = System.nanoTime() - start;
		System.out.println("maxCount = " + maxCount + ", value = " + max);
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
