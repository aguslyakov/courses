import java.util.*;

class EditDistance {
	public static int getEditDistance(String s, String t) {
		// write your code here
		int[][] d = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < s.length() + 1; i++)
			d[i][0] = i;
		for (int j = 0; j < t.length() + 1; j++)
			d[0][j] = j;

		int min;

		for (int i = 1; i <= s.length(); i++)
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1))
					// match
					min = d[i - 1][j - 1];
				else {
					// mismatch
					min = d[i - 1][j - 1] + 1;
					// insertion
					if ((d[i][j - 1] + 1) < min)
						min = d[i][j - 1] + 1;
					// deletion
					if ((d[i - 1][j] + 1) < min)
						min = d[i - 1][j] + 1;
				}
				d[i][j] = min;

			}

		return d[s.length()][t.length()];

	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String t = scan.next();
		System.out.println(getEditDistance(s, t));
	}

}
