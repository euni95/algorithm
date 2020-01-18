package study_190813;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7569_토마토 { // 토마토_190813
	static int M, N, H;
	static int[][][] store;
	static int result = -1;
	static int[] dx = { -1, 1, 0, 0, 0, 0};
	static int[] dy = { 0, 0, -1, 1, 0, 0};
	static int[] dz = { 0, 0, 0, 0, -1, 1};
	
	static class Point {
		int x; int y; int z;
		
		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken());
		
		boolean check = true;
		store = new int[N][M][H];
		Queue<Point> q = new LinkedList<>();
		for(int l = 0; l < H; l++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					store[i][j][l] = Integer.parseInt(st.nextToken());
					
					if (store[i][j][l] == -1 || store[i][j][l] == 0) {
						check = false;
					}
					else {
						q.add(new Point(i, j, l));
					}
				}
			}
		}
		if (check) result = 0;
		else {
			boolean[][][] visited = new boolean[N][M][H];

			while(!q.isEmpty()) {
				
				int qSize = q.size();
				for(int i = 0; i < qSize; i++) {
					Point temp = q.poll();
					int x = temp.x;
					int y = temp.y;
					int z = temp.z;
					
					for (int j = 0; j < 6; j++) {
						int tx = x + dx[j];
						int ty = y + dy[j];
						int tz = z + dz[j];

						if (tx >= N || ty >= M  || tz >= H || tx < 0 || ty < 0 || tz < 0) {
							continue;
						}
						
						if (!visited[tx][ty][tz] && store[tx][ty][tz] == 0) {
							visited[tx][ty][tz] = true;
							store[tx][ty][tz] = 1;
							q.add(new Point(tx, ty, tz));
						}
					}
					
				}
				result++;
			}
			
			for(int l = 0; l < H; l++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (store[i][j][l] == 0) {
							result = -1;
							break;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
