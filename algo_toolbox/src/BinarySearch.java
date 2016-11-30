import java.io.*;
import java.util.*;

public class BinarySearch {

	static int bSearchStep(int[] a, int s, int e, int x) {

		if (s > e)
			return -1;

		int r = -1;

		int m = s + (e - s) / 2;

		if (a[m] == x)
			return m;

		if (s == e)
			return -1;
		// shortcut at right end for interval of two
		// if ((e - s) == 1)
		// if (a[e] == x)
		// return e;

		if (a[m] > x) {
			r = bSearchStep(a, s, m - 1, x);
		} else
			r = bSearchStep(a, m + 1, e, x);

		return r;
	}

	static int binarySearch(int[] a, int x) {
		int left = 0, right = a.length - 1;
		// write your code here

		return bSearchStep(a, left, right, x);
	}

	static int linearSearch(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x)
				return i;
		}
		return -1;
	}

	static void test() {
		int[] a = new int[] { 1, 5, 8, 12, 13 };
		int[] b = new int[] { 11, 1, 8, 1, 5 };
		for (int i = 0; i < b.length; i++) {
			// replace with the call to binarySearch when implemented
			System.out.print(binarySearch(a, b[i]) + " ");
		}
		System.exit(0);
	}

	public static void main(String[] args) {
//		test();

		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextInt();
		}

		for (int i = 0; i < b.length; i++) {
			// replace with the call to binarySearch when implemented
			System.out.print(binarySearch(a, b[i]) + " ");
		}
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
