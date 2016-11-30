import java.io.*;
import java.util.*;

public class Sorting {
	private static Random random = new Random();

	private static int[] partition3(int[] a, int l, int r) {
		// write your code here
		
		int m2 = partition2 (a,l,r); //index of last element less or equal to selected
		int m1 = m2; //index of last of selected element(s)

		for (int i = m2-1; i >= l; i--) {
			if (a[i] == a[m2]) {
				m1--;
				int t = a[i];
				a[i] = a[m1];
				a[m1] = t;
			}
		}

		int[] m = { m1, m2 };
		return m;
	}

	private static void randomizedQuickSort3(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		int k = random.nextInt(r - l + 1) + l;
		int t = a[l];
		a[l] = a[k];
		a[k] = t;

		// use partition3
		int[] m = partition3(a, l, r);
		randomizedQuickSort3(a, l, m[0]-1);
		randomizedQuickSort3(a, m[1]+1, r);
	}

	private static int partition2(int[] a, int l, int r) {
		int x = a[l];
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] <= x) {
				j++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[l];
		a[l] = a[j];
		a[j] = t;
		return j;
	}

	private static void randomizedQuickSort(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		int k = random.nextInt(r - l + 1) + l;
		int t = a[l];
		a[l] = a[k];
		a[k] = t;
		// use partition3
		int m = partition2(a, l, r);
		randomizedQuickSort(a, l, m - 1);
		randomizedQuickSort(a, m + 1, r);
	}

	public static void test() {
		int n = random.nextInt(1000);
		int[] a = new int[n];
		
		for (int i = 0; i<n;i++) {
			a[i] = random.nextInt(100);
		}
		
		randomizedQuickSort3(a, 0, a.length - 1);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.exit(0);
		
	}
	public static void main(String[] args) {
		//test();
		
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		
		randomizedQuickSort3(a, 0, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
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
