import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
	static long getMaxPairwiseProduct(long[] numbers) {
		long result = 0;
		int n = numbers.length;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (numbers[i] * numbers[j] > result) {
					result = numbers[i] * numbers[j];
				}
			}
		}
		return result;
	}

	static long getMaxPairwiseProductFast(long[] numbers) {
		int n = numbers.length;

		int max_index1 = -1;
		for (int i = 0; i < n; ++i)
			if ((max_index1 == -1) || (numbers[i] > numbers[max_index1]))
				max_index1 = i;

		int max_index2 = -1;
		for (int j = 0; j < n; ++j)
			if ((j != max_index1)
					&& ((max_index2 == -1) || (numbers[j] > numbers[max_index2])))
				max_index2 = j;

		return numbers[max_index1] * numbers[max_index2];
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		long[] numbers = new long[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();	
		}
		System.out.println(getMaxPairwiseProductFast(numbers));
		
		
/*		while (true) {
			int n = (int)(Math.random() * 1000) + 2;
			long[] numbers = new long[n];
			System.out.printf("n = %d%n",n);
			
			for (int i=0;i<n;i++) {
				numbers[i] = (long)(Math.random() * 10000);
				System.out.printf("%d ",numbers[i]);
			}
			System.out.println();
			
			long r1 = getMaxPairwiseProduct(numbers);
			long r2 = getMaxPairwiseProductFast(numbers);
			System.out.printf("r1 = %d r2 = %d %n", r1, r2);
			
			if (r1 == r2)
				System.out.println("OK");
			else
				break;
		}
*/		
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}