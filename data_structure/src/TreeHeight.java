import java.util.*;
import java.io.*;

public class TreeHeight {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		FastScanner(String fileName) {
			InputStream file_stream = null;
			try {
				file_stream = new FileInputStream(fileName);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			in = new BufferedReader(new InputStreamReader(file_stream));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeightIn {
		int n;
		int parent[];
		private int[] maxHeights;

		void read() throws IOException {
			 FastScanner in = new FastScanner();
//			FastScanner in = new FastScanner("./test/21");
			n = in.nextInt();
			maxHeights = new int[n];
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
				maxHeights[i] = 0;
			}
		}

		int computeHeight() {
			// Replace this code with a faster implementation
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i]) {
					height++;
					if ((parent[i] >-1) && (maxHeights[parent[i]] > 0)) {
						height = maxHeights[parent[i]] + height;
						break;
					}
				}
				maxHeights[vertex] = height;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new TreeHeight().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeightIn tree = new TreeHeightIn();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
