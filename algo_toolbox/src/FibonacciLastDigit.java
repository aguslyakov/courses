import java.util.*;

public class FibonacciLastDigit {
	private static int getFibonacciLastDigit(int n) {
		if (n <= 1)
			return n;
		int iMinus2 = 0; 
		int iMinus1 = 1; 
		int curI = 0;
		
		for (int i=2; i<=n;i++) {
			curI = (iMinus2 + iMinus1) % 10;
			iMinus2 = iMinus1;
			iMinus1 = curI;
		}

		return curI;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		int c = getFibonacciLastDigit(n);
		System.out.println(c);
		//System.out.println(calc_fib_iter(n));
	}
	
	/*private static long calc_fib_iter(int n) {
		   if (n <= 1)
			   return n;
		   long[] fibNums = new long[n+1];
		   fibNums[0] = 0L;
		   fibNums[1] = 1L;
		   for (int i=2; i<=n;i++) {
			   fibNums[i] = fibNums[i-2] + fibNums[i-1];
		   }
		   
		   return fibNums[n];
		  
	  }
*/
}
