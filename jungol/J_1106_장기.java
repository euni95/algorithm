import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J_1106_장기 { // 장기
	static int size;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, jolX, jolY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int malX = Integer.parseInt(st.nextToken());
		int malY = Integer.parseInt(st.nextToken());

		jolX = Integer.parseInt(st.nextToken());
		jolY = Integer.parseInt(st.nextToken());

		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(malX, malY));
		visited[malX][malY] = true;

		bfs(q, visited);
		System.out.println(size + 1);
	}

	static int[] dx = { -2, -2, 2, 2, -1, -1, 1, 1 };
	static int[] dy = { -1, 1, -1, 1, -2, 2, -2, 2 };

	private static void bfs(Queue<Point> q, boolean[][] visited) {
		while (!q.isEmpty()) {
			int qSize = q.size();

			for (int t = 0; t < qSize; t++) {
				Point temp = q.poll();

				for (int i = 0; i < 8; i++) {
					int x = temp.x + dx[i];
					int y = temp.y + dy[i];
					if (x < 0 || y < 0 || x >= N || y >= M)
						continue;
					if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y])
						continue;

					if (x == jolX && y == jolY)
						return;
					q.add(new Point(x, y));
					visited[x][y] = true;
				}
			}
			size++;
		}
		
	}
}
