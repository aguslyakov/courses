import java.util.*;
import java.util.Scanner;

public class Change {
	private static int getChange(int n) {
		int[] coin = new int[] { 10, 5, 1 };
		int r = n;
		int nCoins = 0;
		for (int i = 0; i < coin.length; i++) {
			nCoins += r / coin[i];
			r = r % coin[i];
		}
		return nCoins;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		System.out.println(getChange(n));

	}
}
