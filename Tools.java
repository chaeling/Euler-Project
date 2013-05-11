package number;

public class Tools {
  public static boolean isPrime(int n){
		if(n < 10){
			if(n == 2 || n == 3 || n == 5 || n == 7)
				return true;
		}else{
			if(n%2 != 0){
				for(int i = 3; i <= Math.sqrt(n); i += 2)
					if(n%i == 0)
						return false;
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPalindrome(String s){
		return s.equals(new StringBuilder(s).reverse().toString());
	}
	
	public static boolean isPalindrome(int n){
		int temp = n, digit, rev = 0;
		while(temp != 0){
			digit = temp % 10;
			rev = rev * 10 + digit;
			temp /= 10;
		}
		return rev == n;
	}
	
	public static int primesFactorNum(int n){
		int count = 0;
		int end = (int) Math.sqrt(n);
		for(int i = 2; i <= end; i++)
			if(n % i == 0){
				while(n % i == 0)
					n /= i;
				end = (int) Math.sqrt(n);
				count++;
			}
		if(n > 1)
			count++;
		return count;
	}
}
