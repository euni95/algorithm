import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14442_벽부수고이동하기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
				visited[i][j] = K + 1;
			}
		}
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
		
		visited[0][0] = 0;
		int cnt = 1;
		boolean check = false;
		exit : while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				if(temp.x == N - 1 && temp.y == M - 1) {
					check = true;
					break exit;
				}
				
				for(int j = 0; j < 4; j++) {
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];
					
					if(tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
					
					int t_wall = temp.wall;
					if(map[tx][ty] == 1) {
						if(t_wall == K) continue;
						else {
							t_wall++;
						}
					}
					
					if(visited[tx][ty] <= t_wall) continue;
					visited[tx][ty] = t_wall;
					
					q.add(new Point(tx, ty, t_wall));
				}
			}
			cnt++;
		}
		if(check) System.out.println(cnt);
		else System.out.println(-1);
	}
	static class Point {
		int x, y, wall;

		public Point(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
		
	}
}
