import java.util.*;

public class GCD {
	private static int gcd(int a, int b) {
		int current_gcd = 1;
		for (int d = 2; d <= a && d <= b; ++d) {
			if (a % d == 0 && b % d == 0) {
				if (d > current_gcd) {
					current_gcd = d;
				}
			}
		}

		return current_gcd;
	}

	private static int efficientGCD(int a, int b) {
		// int gcd = 1;
		if (a % b != 0) {

			if (a >= b)
				return efficientGCD(a % b, b);
			else
				return efficientGCD(b % a, a);

		} else
			return b;
	}

	public static void stressTest() {
		int a;
		int b;
		int g;
		int eg;
		for (int i = 0; i < 100; i++) {
			a = (int) (Math.random() * 10000) + 1;
			b = (int) (Math.random() * 10000) + 1;
			System.out.printf("%d %d\n", a, b);
			g = gcd(a, b);
			eg = efficientGCD(a, b);
			System.out.printf("gcd = %d \n", g);
			System.out.printf("efficient gcd = %d \n", eg);

			if (g != eg) {
				System.out.println("ERROR");
				break;
			}

		}

	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		// System.out.println(gcd(a, b));
		System.out.println(efficientGCD(a, b));

		// stressTest();
	}
}
