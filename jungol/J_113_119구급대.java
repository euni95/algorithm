import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J_113_119구급대 {
	static int M, N;
	static int endX, endY;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		endX = Integer.parseInt(st.nextToken());
		endY = Integer.parseInt(st.nextToken());

		int[][] map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Point> q = new LinkedList<>();
		int[][][] visited = new int[M][N][4];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		q.add(new Point(0, 0, -1, 0));
		
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Point temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];
				
				if(tx < 0 || ty < 0 || tx >= M || ty >= N) continue;
				if(map[tx][ty] == 0) continue;

				int cur = temp.cur;
				if(temp.dir != i) cur = cur + 1;
				
				if(tx == endX && ty == endY) {
					min = Math.min(cur, min);
					continue;
				}
				if(visited[tx][ty][i] <= cur) continue;
				
				visited[tx][ty][i] = cur;
				q.add(new Point(tx, ty, i, cur));
			}
		}
		System.out.println(min - 1);
	}

	static class Point {
		int x;
		int y;
		int dir;
		int cur;

		public Point(int x, int y, int dir, int cur) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cur = cur;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + ", cur=" + cur + "]";
		}

	}
}
