import java.util.Scanner;

public class Fib {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }
  
  private static long calc_fib_iter(int n) {
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

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();
    
    System.out.println(calc_fib_iter(n));
    

    
  }
}
