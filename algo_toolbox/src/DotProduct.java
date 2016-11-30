import java.util.*;

public class DotProduct {
    private static long minDotProduct(int[] a, int[] b) {
        
    	Arrays.sort(a);
        Arrays.sort(b);
        
    	//write your code here
        long result = 0;
        
        for (int i=0;i<a.length;i++) {
        	result+=(long)a[i]* b[b.length-1-i];
        }
        /*for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }*/
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(minDotProduct(a, b));
    }
}

