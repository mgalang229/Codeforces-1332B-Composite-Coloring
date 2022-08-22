import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*

0  1  2  3
6 10 15 12

numbers and their smallest prime divisors:
6 = 2
10 = 2
15 = 3
12 = 2

2 = [0, 1, 3]
3 = [2]

there are exactly 11 prime numbers below sqrt(1000)

 */

public class AuthorSol {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			ArrayList<Integer>[] arr = new ArrayList[10001];
			for (int i = 0; i < n; i++) {
				arr[getPrimeDiv(a[i])] = new ArrayList<>();
			}
			for (int i = 0; i < n; i++) {
				arr[getPrimeDiv(a[i])].add(i);
			}
			int[] colors = new int[n];
			Arrays.fill(colors, 0);
			int color = 1;
			for (int i = 1; i <= 1000; i++) {
				if (arr[i] != null) {
					for (int x : arr[i]) {
						colors[x] = color;
					}
					color++;
				}
			}
			out.println(color - 1);
			for (int i = 0; i < n; i++) {
				out.print(colors[i] + " ");
			}
			out.println();
		}
		out.close();
	}
	
	static int getPrimeDiv(int x) {
		for (int i = 2; i <= x; i++) {
			if (x % i == 0) {
				return i;
			}
		}
		return -1;
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
