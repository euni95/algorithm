import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J_1462_보물섬 { // 보물섬
	static int N, M;
	static char[][] map;
	static int max;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		System.out.println(max - 1);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs(int x, int y) {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		int len = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Point temp = q.poll();

				for (int j = 0; j < 4; j++) {
					x = temp.x + dx[j];
					y = temp.y + dy[j];

					if (x < 0 || y < 0 || x >= N || y >= M 
							|| visited[x][y] || map[x][y] == 'W') {
						continue;
					}
					q.add(new Point(x,y));
					visited[x][y] = true;
				}
			}
			len++;
		}
		if(len > max) max = len;
	}

}
