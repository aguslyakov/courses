import java.util.*;

public class FibonacciHuge {
	private static List<Long> getPisanoPeriod(long m) {
		List<Long> seq = new ArrayList<Long>();

		long curI = 0;

		seq.add(0L);
		seq.add(1L);
		
//		System.out.print("0 1 ");
		
		while (true) {
			curI = (seq.get(seq.size() - 2) + seq.get(seq.size() - 1)) % m;

//			System.out.printf("%d ", curI);
			
			if ((curI == 1) && (seq.get(seq.size() - 1) == 0)) {
				break;
			}

			seq.add(curI);
		}
		seq.remove(seq.size() - 1);
		
		return seq;
	}

	private static long getFibonacciHuge(long n, long m) {
		// write your code here
		if (m <= 1)
			return m;
		
		List<Long> period = getPisanoPeriod(m);

//		System.out.println(period);
		
		Long remainder = period.get((int) (n % period.size()));
		
		return remainder;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		
		scanner.close();
		
		System.out.println (getFibonacciHuge(n, m));

	}
}
