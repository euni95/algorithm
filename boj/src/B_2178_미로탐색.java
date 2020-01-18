import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178_미로탐색 { // 미로 탐색
	static int N, M;
	static int[][] maze;

	static class Point {
		int x;
		int y;

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
		maze = new int[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 1; j < M + 1; j++) {
				maze[i][j] = temp[j - 1] - '0';
			}
		}
		System.out.println(move(1, 1));
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int move(int x, int y) {
		int movePoint = 1;
		boolean[][] visited = new boolean[N + 1][M + 1];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;

		a : while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				x = temp.x;
				y = temp.y;
				
				for (int j = 0; j < 4; j++) {
					int tx = x + dx[j];
					int ty = y + dy[j];

					if (tx == N && ty == M) {
						movePoint++;
						break a;
					}
					if (tx <= 0 || ty <= 0 || tx > N || ty > M) continue;
					if (visited[tx][ty] == true || maze[tx][ty] == 0) continue;

					visited[tx][ty] = true;
					q.add(new Point(tx, ty));
				}	
			}
			movePoint++;
		}
		return movePoint;
	}

}
