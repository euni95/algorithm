import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW_1249_보급로 {
	static int T, N;
	static int[][] map;
	static int[][] visited;
	static Queue<Point> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
					visited[i][j] = INF;
				}
			}
			
			q = new LinkedList<>();
			visited[0][0] = 0;
			q.add(new Point(0, 0));
			
			while(!q.isEmpty()) {
				Point temp = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int tx = temp.x + dx[i];
					int ty = temp.y + dy[i];
					
					if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
					if(visited[temp.x][temp.y] + map[tx][ty] >= visited[tx][ty]) continue;
					visited[tx][ty] = visited[temp.x][temp.y] + map[tx][ty];
					q.add(new Point(tx, ty));
				}
			}
			System.out.println("#" + t + " " + visited[N-1][N-1]);
		}
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
