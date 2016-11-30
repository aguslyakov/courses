import java.util.*;

public class CoveringSegments {

	private static int[] optimalPoints(Segment[] segments) {
		// write your code here
		int[] points = new int[segments.length];

		Arrays.sort(segments);

		int k = 0;
		points[k++] = segments[0].end;
		for (int i = 0; i < segments.length; i++) {
			if (!segments[i].contain(points[k - 1])) {
				points[k++] = segments[i].end;
			}
			;
		}

		// System.out.println(Arrays.toString(points));

		// System.out.println(k);

		int[] pts = new int[k];

		pts = Arrays.copyOfRange(points, 0, k);

		return pts;
	}

	private static class Segment implements Comparable<Segment> {
		int start, end;

		Segment(int start, int end) {
			if (start > end) {
				this.end = start;
				this.start = end;
			} else {
				this.start = start;
				this.end = end;
			}
		}

		public int compareTo(Segment segment) {
			if (segment.end > this.end)
				return -1;
			return 1;
		}

		public boolean contain(int point) {
			if ((point >= start) && (point <= end))
				return true;
			return false;
		}

		public String toString() {
			return start + " - " + end + "; ";
		}

	}

	public static void test() {
		int n = 20;
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			segments[i] = new Segment((int) (Math.random() * 10000) + 1,
					(int) (Math.random() * 10000) + 1);
		}
		/*
		 * segments[2] = new Segment(1, 3); segments[0] = new Segment(2, 5);
		 * segments[1] = new Segment(3, 6); segments[3] = new Segment(4, 7);
		 */
		System.out.println(Arrays.deepToString(segments));

		System.out.println(Arrays.toString(optimalPoints(segments)));
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			int start, end;
			start = scanner.nextInt();
			end = scanner.nextInt();
			segments[i] = new Segment(start, end);
		}
		scanner.close();

		int[] points = optimalPoints(segments);
		System.out.println(points.length);
		for (int point : points) {
			System.out.print(point + " ");
		}

		// ----------------------------------------------
		// test();

	}
}
