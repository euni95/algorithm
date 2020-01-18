import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1953_탈주범검거2 {
	static int N, M, R, C, L;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 };
	static int[] v = { 0, 15, 5, 10, 9, 12, 6, 3 };
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 지하 터널 지도 크기
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// 맨홀 뚜껑 위치
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			// 경과된 시간
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = v[temp];
				}
			}

			result = 1;
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(R, C));
			boolean[][] visited = new boolean[N][M];
			visited[R][C] = true;
			int cnt = 0;
			while (!q.isEmpty()) {
				int qSize = q.size();

				if (cnt == L - 1) break;
				for (int e = 0; e < qSize; e++) {
					Point temp = q.poll();

					for (int i = 0; i < 4; i++) {
						if ((map[temp.x][temp.y] & (1 << i)) == 0) {
							continue;
						}

						int tx = temp.x + dx[i];
						int ty = temp.y + dy[i];

						if (tx < 0 || ty < 0 || tx >= N || ty >= M || visited[tx][ty] || map[tx][ty] == 0) continue;
						if ((map[tx][ty] & (1 << ((i + 2) % 4))) == 0) continue;

						q.add(new Point(tx, ty));
						visited[tx][ty] = true;
						result++;
					}

				}
				cnt++;
			}
			System.out.println("#" + t + " " + result);
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
