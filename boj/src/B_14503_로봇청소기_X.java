import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14503_로봇청소기_X {
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 }; // 북동남서

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int robotX = Integer.parseInt(st.nextToken());
		int robotY = Integer.parseInt(st.nextToken());
		int robotDir = Integer.parseInt(st.nextToken());

		int[][] place = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		int x = robotX, y = robotY, dir = robotDir;
		place[x][y] = -1;

		clean : while (true) {
			int tDir = dir;
			for (int i = 0; i < 4; i++) {
				tDir = (tDir + 3) % 4;
				int tx = x + dx[tDir];
				int ty = y + dy[tDir];
				if (tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
				if (place[tx][ty] == 0) {
					place[tx][ty] = -1;
					cnt++;
					x = tx; y = ty; dir = tDir;
					continue clean;
				}
			}
			x = x + dx[(dir + 2) % 4];
			y = y + dy[(dir + 2) % 4];
			if (x < 0 || y < 0 || x >= N || y >= M || place[x][y] == 1) break;
		}
		System.out.println(cnt);
	}

	static class Point {
		int x, y, dir;

		public Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}
}
