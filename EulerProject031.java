/*
 * Coin sums
 * Problem 31
 * 
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:

 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
package number;

public class CoinSums {
	
//	final static int coins[] = {200, 100, 50, 20, 10, 5, 2, 1};
//	public static int findposs(int money, int maxcoin){
//		int sum = 0;
//		if(maxcoin == 7)
//			return 1;
//		for(int i = maxcoin; i < 8; i++){
//			if(money - coins[i] == 0)
//				sum += 1;
//			if(money - coins[i] > 0) 
//				sum += findposs(money - coins[i], i);
//		}
//		return sum;
//	}
//	
	public static void main(String[] args) {
		long start = System.nanoTime();
	/*	int count = 0;
		for(int i = 0; i <= 1; i++)
			for(int j = 0; j <= 2; j++)
				for(int k = 0; k <= 4; k++)
					for(int m = 0; m <= 10; m++)
						for(int n = 0; n <= 20; n++)
							for(int p = 0; p <= 50; p++)
								for(int q = 0; q <= 100; q++)
									for(int r = 0; r <= 200; r++)
										if(200 * i + 100 * j + 50 * k + 20 * m + 10 * n + 5 * p + 2 * q + r == 200)
											count++;
		System.out.println(count);*/
		
		final int TOTAL = 200;
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
	    int[] ways = new int[TOTAL + 1];
	    ways[0] = 1;

	    for(int coin: coins)
	    	for(int j = coin; j <= TOTAL; j++)
			  	ways[j] += ways[j - coin];
	    System.out.println("Result: " + ways[TOTAL]);
		
		
		
		long time = System.nanoTime() - start; 
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
}
