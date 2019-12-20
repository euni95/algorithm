import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] cave;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			cave = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] cost = new int[N][N];
			for(int i = 0; i < N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);

			cost[0][0] = cave[0][0];
			
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(0, 0));
			while(!q.isEmpty()) {
				Point temp = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int tx = temp.x + dx[i];
					int ty = temp.y + dy[i];
					
					if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
					if(cost[tx][ty] <= cost[temp.x][temp.y] + cave[tx][ty]) continue;
					cost[tx][ty] = cost[temp.x][temp.y] + cave[tx][ty];
					
					q.add(new Point(tx, ty));
				}
			}
			System.out.println("Problem " + t++ +": " + cost[N-1][N-1]);
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
