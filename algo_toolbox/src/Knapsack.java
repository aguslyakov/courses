import java.util.*;

public class Knapsack {
	static int optimalWeight(int W, int[] w) {
		int[][] maxWeight = new int[W + 1][w.length + 1];
		// / first row & columkn -> to 0
		for (int j = 0; j < W + 1; j++)
			maxWeight[j][0] = 0;
		for (int i = 0; i < w.length + 1; i++)
			maxWeight[0][i] = 0;

		// fill in the matrix

		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= w.length; j++) {
				maxWeight[i][j] = maxWeight[i][j - 1];
				if (w[j - 1] <= i) {
					int v = maxWeight[i - w[j - 1]][j - 1] + w[j - 1];
					if ((maxWeight[i][j] < v) && (v <= i))
						maxWeight[i][j] = v;
				}
			}
		}
		return maxWeight[W][w.length];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int W, n;
		W = scanner.nextInt(); n = scanner.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) { w[i] = scanner.nextInt(); }
		
		scanner.close();

		System.out.println(optimalWeight(W, w));
	}
}
