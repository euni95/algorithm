import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17391_무한부스터 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new Point(0, 0, map[0][0], 0));
		visited[0][0] = true;
		int min = Integer.MAX_VALUE;
		int[] dx = {1, 0}, dy = { 0, 1};
		while(!q.isEmpty()) {
			Point temp = q.poll();
			for(int i = 0; i < 2; i++) {
				int tx = temp.x;
				int ty = temp.y;
				
				for(int j = 0; j < temp.item; j++) {
					tx += dx[i];
					ty += dy[i];
					if(tx < 0 || ty < 0 || tx >= N || ty >= M) {
						tx -= dx[i];
						ty -= dy[i];
						break;
					}
					if(visited[tx][ty]) continue;
					if(temp.cnt + 1 >= min) continue;
					if(tx == N - 1 && ty == M - 1) {
						min = Integer.min(min, temp.cnt + 1);
						continue;
					}
					visited[tx][ty] = true;
					q.add(new Point(tx, ty, map[tx][ty], temp.cnt + 1));
				}
			}
		}
		System.out.println(min);
	}

	static class Point {
		int x, y, item, cnt;

		public Point(int x, int y, int item, int cnt) {
			this.x = x;
			this.y = y;
			this.item = item;
			this.cnt = cnt;
		}

	}
}
