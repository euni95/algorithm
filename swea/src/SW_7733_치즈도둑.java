import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_7733_치즈도둑 {
	static int N;
	static int[][] cheese;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int day = 1;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			cheese = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					if(day < cheese[i][j]) day = cheese[i][j];
				}
			}

			int max = 0;
			for (int c = 0; c <= day; c++) {
				boolean[][] visited = new boolean[N][N];
				int cnt = 0;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] <= c) {
							visited[i][j] = true;
						} 
						if(!visited[i][j]){
							find(visited, i, j, c);
							cnt++;
						}
					}
				}
				if (max < cnt) max = cnt;
			}
			System.out.println("#" + t + " " + max);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void find(boolean[][] visited, int x, int y, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point temp = q.poll();

			for (int i = 0; i < 4; i++) {
				x = temp.x + dx[i];
				y = temp.y + dy[i];

				if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y])
					continue;
				if (cheese[x][y] <= c) {
					visited[x][y] = true;
					continue;
				}
				visited[x][y] = true;
				q.add(new Point(x, y));
			}
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
