import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1247_최적경로 {
	static int[][] map;
	static Point company, home;
	static int N;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			map = new int[N][2];
			for (int i = 0; i < N; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			min = 99999999;
			perm(0);
			for (int i = 0; i < N; i++) {
				System.out.print(Arrays.toString(map[i]));
			}
			System.out.println("#" + t + " " + min);
		}
	}

	private static void perm(int idx) {
		if (idx == N) {
			int distance = calcDistance();
			if (min > distance) {
				min = distance;
			}
			return;
		}
		for (int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx);
		}
	}

	private static void swap(int i, int idx) {
		int temp[] = map[i];
		map[i] = map[idx];
		map[idx] = temp;
	}

	private static int calcDistance() {
		int distance = 0;
		distance += Math.abs(company.x - map[0][0]) + Math.abs(company.y - map[0][1]);

		for (int i = 0; i < N - 1; i++) {
			if(distance > min) return min + 1;
			distance += Math.abs(map[i][0] - map[i + 1][0]) + Math.abs(map[i][1] - map[i + 1][1]);
		}
		distance += Math.abs(home.x - map[N - 1][0]) + Math.abs(home.y - map[N - 1][1]);

		return distance;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}