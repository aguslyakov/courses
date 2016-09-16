import java.util.Scanner;

class MinMax {
	public long min;
	public long max;

	public MinMax(long min, long max) {
		super();
		this.min = min;
		this.max = max;
	}

	public MinMax() {
		super();
	}
}

public class PlacingParentheses {
	private static int[] digit;
	private static char[] op;
	
	
	//value[i][j]: max and min values for subexpression starting at digit i ending digit j
	private static MinMax[][] value;

	private static long eval(long a, long b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else if (op == '*') {
			return a * b;
		} else {
			// assert false;
			return 0;
		}
	}

	// find min and max for expression between i and j
	private static MinMax calculateMinMax(int i, int j) {
		MinMax result = new MinMax(2 * 1000000000, -2 * 1000000000);
		long MM, mM, Mm, mm;

		for (int k = i; k < j; k++) {
			mm = eval(value[i][k].min, value[k + 1][j].min, op[k]);
			mM = eval(value[i][k].min, value[k + 1][j].max, op[k]);
			Mm = eval(value[i][k].max, value[k + 1][j].min, op[k]);
			MM = eval(value[i][k].max, value[k + 1][j].max, op[k]);

			if (result.min > mm)
				result.min = mm;
			if (result.min > mM)
				result.min = mM;
			if (result.min > Mm)
				result.min = Mm;
			if (result.min > MM)
				result.min = MM;

			if (result.max < mm)
				result.max = mm;
			if (result.max < mM)
				result.max = mM;
			if (result.max < Mm)
				result.max = Mm;
			if (result.max < MM)
				result.max = MM;

		}
		return result;
	}

	//calculate min and max for all subexpressions of 2,3,4 etc digits
	private static long getMaximValue(String exp) {
		// write your code here
		int j;
		for (int s = 1; s < digit.length; s++) {
			for (int i = 0; i < digit.length-s; i++) {
				j = i+s;
				value[i][j] = calculateMinMax(i, j);
			}
		}
		return value[0][digit.length-1].max;
	}

	// fetch digits and operations from string
	private static void transformInput(String s) {
		if (s.length() % 2 == 0) {
			System.out.println("Error: incorrect string");
			return;
		}
		digit = new int[s.length() / 2 + 1];
		op = new char[s.length() / 2];

		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0)
				digit[i/2] = Character.getNumericValue(s.charAt(i));
			else
				op[i/2] = s.charAt(i);
		}

		value = new MinMax[digit.length][digit.length];
		
		//fill in mins and maxs for single digit expressions
		for (int k=0;k<digit.length;k++) {
			value[k][k]=new MinMax(digit[k],digit[k]);
		}
	}

	public static void main(String[] args) {
		//String exp = "5-8+7*4-8+9";
		Scanner scanner = new Scanner(System.in);
		String exp = scanner.next();
		scanner.close();
		transformInput(exp);
		System.out.println(getMaximValue(exp));
	}
}
