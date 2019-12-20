import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1261_알고스팟 {
	static int N, M;
	static int[][] maze;
	static int[][] cnt;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		cnt = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				maze[i][j] = input.charAt(j) - '0';
				cnt[i][j] = Integer.MAX_VALUE;
			}
		}
		cnt[0][0] = 0;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));

		while (!q.isEmpty()) {
			int qSize = q.size();

			for(int qs = 0; qs < qSize; qs++) {
				Point temp = q.poll();

				for (int i = 0; i < 4; i++) {
					int tx = temp.x + dx[i];
					int ty = temp.y + dy[i];

					if (tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
					if(cnt[tx][ty] <= cnt[temp.x][temp.y]) continue;
					if(cnt[tx][ty] > cnt[temp.x][temp.y]+maze[tx][ty]) {
						cnt[tx][ty] = cnt[temp.x][temp.y]+maze[tx][ty];
						q.offer(new Point(tx, ty));
					}
				}
			}
		}
		System.out.println(cnt[N-1][M-1]);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
