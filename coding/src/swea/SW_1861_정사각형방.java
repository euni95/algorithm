import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1861_정사각형방 {
	static int N;
	static int[][] room;
	static int[] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			memo = new int[(N * N) + 1];
			room = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = -1;
			int result = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					bfs(i, j);
					memo[room[i][j]] = cnt;
					if ((cnt == max && room[i][j] < result) || cnt > max) {
						result = room[i][j];
						max = cnt;
					}
				}
			}
			System.out.println("#" + t + " " + result + " " + ++max);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt;

	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		int tx, ty;
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			int qSize = q.size();

			for (int i = 0; i < qSize; i++) {
				Point temp = q.poll();

				for (int j = 0; j < 4; j++) {
					tx = temp.x + dx[j];
					ty = temp.y + dy[j];

					if (tx < 0 || ty < 0 || tx >= N || ty >= N)
						continue;
					if (room[tx][ty] == room[temp.x][temp.y] + 1) {
						if (memo[room[tx][ty]] != 0) {
							cnt = cnt + memo[room[tx][ty]] + 1;
							return;
						}
						q.add(new Point(tx, ty));
						cnt++;
					}
				}
			}
		}
	}
}
