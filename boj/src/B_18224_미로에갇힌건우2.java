import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_18224_미로에갇힌건우2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, m;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] maze = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Point> q = new LinkedList<>();
		int[][][] visited = new int[n][n][2];
		Point start = new Point(0, 0);
		q.add(start);
		visited[0][0][0] = 1;

		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		boolean day = false; // false : 낮, true : 밤
		int cnt = 1; int d = 1;
		
		boolean check = false;
		exit:while (!q.isEmpty()) {
			int qSize = q.size();
			
			for(int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				
				if(temp.x == n-1 && temp.y == n-1) {
					check = true;
					System.out.println(d + " " + (day ? "moon" : "sun"));
					break exit;
				}
				
				for(int j = 0; j < 4; j++) {
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];

					if (tx < 0 || ty < 0 || tx >= n || ty >= n) continue;
					if (maze[tx][ty] == 1 && !day) { // 벽을 만났을 때 낮이면 x
						continue;
					}
					
					int ttx = tx, tty = ty;
					boolean b = false;
					if (maze[tx][ty] == 1 && day) { // 밤이면
						while(true) {
							ttx += dx[j];
							tty += dy[j];
							
							if(ttx < 0 || tty < 0 || ttx >= n || tty >= n) break;
							if(maze[ttx][tty] == 0) {
								tx = ttx;
								ty = tty;
								b = true;
								break;
							}
						}
						if(!b) {
							continue;
						}
					}
					
					if((visited[tx][ty][day ? 1 : 0] & (1 << cnt)) > 0) continue;
					visited[tx][ty][day ? 1 : 0] = (visited[tx][ty][day ? 1 : 0]) | (1 << cnt);
					Point next = new Point(tx, ty);
					q.add(next);
				}
			}
			if(cnt == m) {
				day = !day;
				if(!day) d++;
				cnt = 1;
			} else {
				cnt++;
			}
		}
		if(!check) System.out.println(-1);

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
