import java.util.*;

public class PrimitiveCalculator {

	private static List<Integer> trueOptimal(int n) {
		ArrayList<Integer> min_steps = new ArrayList<Integer>();
		int min;
		// skip index 0 for convenience
		min_steps.add(0);
		min_steps.add(0);
		// System.out.print("1 ");
		for (int i = 2; i <= n; i++) {
			// min - store best number of steps out of 3 options
			min = -1;
			// multiply by 3
			if (i % 3 == 0)
				min = min_steps.get(i / 3);
			// multiply by 2
			if (i % 2 == 0) {
				if ((min == -1) || (min_steps.get(i / 2) < min))
					min = min_steps.get(i / 2);
			}
			// add 1
			if ((min == -1) || (min_steps.get(i - 1) < min))
				min = min_steps.get(i - 1);

			// assign min_steps for i

			min_steps.add(min + 1);

			// System.out.print(min_steps.get(min_steps.size() - 1) + " ");
		}
		// System.out.println();
		
		// -----------------------
		
		// back track the sequence
		List<Integer> numbers = new LinkedList<Integer>();
		int x = n;
		numbers.add(x);
		for (int i = 0; i < min_steps.get(n); i++) {
			if ((x % 3 == 0) && (min_steps.get(x / 3) == min_steps.get(x) - 1)) {
				x /= 3;
				numbers.add(0, x);
			} else if ((x % 2 == 0)
					&& (min_steps.get(x / 2) == min_steps.get(x) - 1)) {
				x /= 2;
				numbers.add(0, x);
			} else {
				x -= 1;
				numbers.add(0, x);
			}

		}
		return numbers;
	}

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();
		 scanner.close();
		List<Integer> lst = trueOptimal(n);
		System.out.println(lst.size() - 1);

		for (Integer x : lst) {
			System.out.print(x + " ");
		}
	}
}
