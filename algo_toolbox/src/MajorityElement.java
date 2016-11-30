import java.util.*;
import java.io.*;

public class MajorityElement {

	private static MajorityResult emptyResult = new MajorityResult(-1, 0);

	private static MajorityResult getMajorityElement(int[] a, int left,
			int right) {
		if (left == right) {
			return emptyResult;
		}
		if (left + 1 == right) {
			return new MajorityResult(a[left], 1);
		}
		// write your code here

		int m = left + (right - left) / 2;

		MajorityResult lm = getMajorityElement(a, left, m);
		MajorityResult rm = getMajorityElement(a, m, right);

		// no majority elements in both
		if ((lm.value == -1) && (rm.value == -1))
			return emptyResult;

		// both have same majority elements
		if (lm.value == rm.value) {
			lm.num += rm.num;
			return lm;
		}

		// left has but not like right - have to re-scan right for number of
		// elements like in left
		if (lm.value > -1) {
			int z = 0;
			for (int i = m; i < right; i++) {
				if (a[i] == lm.value)
					z++;
			}
			if ((lm.num + z) > (right - left) / 2) {
				lm.num += z;
				return lm;
			}
		}
		// right has but not like left - have to re-scan left for number of
		// elements like in left
		if (rm.value > -1) {
			int z = 0;
			for (int i = left; i < m; i++) {
				if (a[i] == rm.value)
					z++;
			}
			if ((rm.num + z) > (right - left) / 2) {
				rm.num += z;
				return rm;
			}

		}

		return emptyResult;

	}

	static void test() {
		int[] a = new int[] { 2, 3, 2, 6, 3 };
		MajorityResult me = getMajorityElement(a, 0, a.length);
		
		System.out.println (me.toString());
		
		if (me.value != -1) {
			System.out.println(1);
		} else {
			System.out.println(0);
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
		if (getMajorityElement(a, 0, a.length).value != -1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static class MajorityResult {
		public int value;
		public int num;

		public MajorityResult(int value, int num) {
			super();
			this.value = value;
			this.num = num;
		}
		
		public String toString() {
			return "val = " + value + " num = " + num;
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
