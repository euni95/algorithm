import java.util.Scanner;

public class B_1012_유기농배추 { // 유기농 배추
	static int cnt;
	static int M, N, K;
	static int[][] farm;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();

			farm = new int[M][N];

			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				farm[x][y] = 1;
			}

			boolean[][] visited = new boolean[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] || farm[i][j] == 0)
						continue;
					test(i, j, visited);
					cnt++;
				}
			}
			System.out.println(cnt);
			cnt = 0;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	private static void test(int x, int y, boolean[][] visited) {
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];

			if (tx < 0 || ty < 0 || tx >= M || ty >= N) continue;
			if (!visited[tx][ty] && farm[tx][ty] == 1) {
				visited[tx][ty] = true;
				test(tx, ty, visited);
			}
		}
	}
}
