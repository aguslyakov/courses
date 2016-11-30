import java.util.*;

public class Inversions {

	private static long getNumberOfInversions(int[] a, int[] b, int left,
			int right) {
		long numberOfInversions = 0;
		if (right <= left + 1) {
			return numberOfInversions;
		}
		int ave = (left + right) / 2;
		numberOfInversions += getNumberOfInversions(a, b, left, ave);
		numberOfInversions += getNumberOfInversions(a, b, ave, right);
		// calculate inversions
		long n = 0;
		for (int i = left; i < ave; i++) {
			int j = ave;
			while ((j < right) && (a[i] > a[j])) {
				n++;
				j++;
			}
		}

		numberOfInversions += n;

		// merge into b
		int i = left;
		int j = ave;

		for (int k = left; k < right; k++) {
			if (j >= right)
				b[k] = a[i++];
			else if (i >= ave)
				b[k] = a[j++];
			else if (a[i] <= a[j])
				b[k] = a[i++];
			else if (a[i] > a[j])
				b[k] = a[j++];
		}
		
		// copy into a
		for (int k = left; k < right; k++)
			a[k] = b[k];

		return numberOfInversions;
	}

	static void test() {
//		int a[] = {2,3,12,4,5,6,7,8,9};
		int a[] = {1,0};
		int b[] = new int[a.length];
		System.out.println(getNumberOfInversions(a, b, 0, a.length));
		System.out.println(Arrays.toString(a));
		System.exit(0);
	}
	public static void main(String[] args) {
		//test();
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		System.out.println(getNumberOfInversions(a, b, 0, a.length));
	}
}
