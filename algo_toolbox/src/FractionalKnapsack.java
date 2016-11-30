import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
	private static double getOptimalValue(int capacity, int[] values,
			int[] weights) {
		double value = 0;
		// System.err.println(Arrays.toString(values));
		// System.err.println(Arrays.toString(weights));
		// System.err.printf("capacity = %d, value = %4f \n", capacity, value);
		while (capacity > 0) {
			int maxVindex = -1;
			for (int i = 0; i < values.length; i++) {
				if ((weights[i] > 0)
						&& ((maxVindex == -1) || ((double) values[i]
								/ weights[i] > (double) values[maxVindex]
								/ weights[maxVindex])))
					maxVindex = i;
			}

			if (maxVindex == -1) {
				// System.err.println("capacity exceeds total weight");
				break;
			}

			if (capacity > weights[maxVindex]) {
				value += values[maxVindex];
				capacity -= weights[maxVindex];
				weights[maxVindex] = 0;
			} else {
				value += (double) capacity * values[maxVindex]
						/ weights[maxVindex];
				weights[maxVindex] -= capacity;
				capacity = 0;
			}
			// System.err.println(Arrays.toString(weights));
			// System.err.printf("capacity = %d, value = %4f \n", capacity,
			// value);

		}

		return value;
	}

	private static void test() {
		System.err.printf(
				"%f",
				getOptimalValue(50, new int[] { 0, 99, 119 }, new int[] { 19,
						49, 29 }));
	}

	public static void main(String args[]) {
		// test();

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		System.out.println(getOptimalValue(capacity, values, weights));
	}
}
