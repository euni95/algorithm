
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14501_퇴사 {
	static Point[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new Point[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			arr[i] = new Point(i, T, P, P);
		}
		max = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i].T + i - 1 <= N)
				calc(i);
		}
		System.out.println(max);
	}

	static int max = 0;

	private static void calc(int n) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(n, arr[n].T, arr[n].P, arr[n].P));

		while (!q.isEmpty()) {
			Point temp = q.poll();
			if (temp.sum > max)
				max = temp.sum;

			for (int i = temp.N + 1; i <= N; i++) {
				if ((arr[i].T + i - 1) <= N && temp.T + temp.N - 1 < i) {
					q.add(new Point(i, arr[i].T, arr[i].P, temp.sum + arr[i].P));
				}
			}
		}
	}

	static class Point {
		int N;
		int T;
		int P;
		int sum;

		public Point(int n, int t, int p, int sum) {
			N = n;
			T = t;
			P = p;
			this.sum = sum;
		}
	}
}
