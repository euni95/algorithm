import java.util.Scanner;

public class SW_3234_준환이의양팔저울_1_answer {

	static int result;

	public static void main(String args[]) throws Exception {
//    	System.setIn(new FileInputStream("input_3234.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] w;
		boolean[] v;
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			w = new int[N];
			for (int i = 0; i < N; i++) {
				w[i] = sc.nextInt();
			}
			result = 0;
			dfs(w, 0, 0, 0);
			System.out.println("#" + t + " " + result);
		}
	}

	static void dfs(int[] w, int left, int right, int depth) {
		if (left < right) {
			return;
		}
		if (depth == w.length) {
			result++;
			return;
		}
		for (int i = depth; i < w.length; i++) {
			swap(w, i, depth);
			dfs(w, left + w[depth], right, depth + 1);
			dfs(w, left, right + w[depth], depth + 1);
			swap(w, depth, i);
		}
	}

	static void swap(int[] w, int i, int j) {
		int t = w[i];
		w[i] = w[j];
		w[j] = t;
	}
}