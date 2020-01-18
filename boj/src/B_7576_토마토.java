import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576_토마토 { // 토마토_190813
	static int M;
	static int N;
	static int[][] store;
	static int result = -1;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	static class Point {
		int x; int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로

		boolean check = true;
		store = new int[N][M];
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				store[i][j] = Integer.parseInt(st.nextToken());
				
				if (store[i][j] == -1 || store[i][j] == 0) {
					check = false;
				}
				else {
					q.add(new Point(i, j));
				}
			}
		}
		if (check) result = 0;
		else {
			boolean[][] visited = new boolean[N][M];

			while(!q.isEmpty()) {
				
				int qSize = q.size();
				for(int i = 0; i < qSize; i++) {
					Point temp = q.poll();
					int x = temp.x;
					int y = temp.y;
					
					for (int j = 0; j < 4; j++) {
						int tx = x + dx[j];
						int ty = y + dy[j];

						if (tx >= N || ty >= M || tx < 0 || ty < 0) {
							continue;
						}
						
						if (!visited[tx][ty] && store[tx][ty] == 0) {
							visited[tx][ty] = true;
							store[tx][ty] = 1;
							q.add(new Point(tx, ty));
						}
					}
					
				}
				result++;
			}
			

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (store[i][j] == 0) {
						result = -1;
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
