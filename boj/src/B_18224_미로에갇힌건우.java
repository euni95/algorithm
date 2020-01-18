import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_18224_미로에갇힌건우 {

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
		Point start = new Point(0, 0, 1, 0, 1, false);
		q.add(start);
		visited[0][0][0] = 1;

		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		boolean check = false;
		exit:while (!q.isEmpty()) {
			Point temp = q.poll();
			if(temp.x == n-1 && temp.y == n-1) {
				check = true;
				System.out.println(temp.day ? temp.moon +  " moon" : temp.sun + " sun");
				break exit;
			}
			for (int i = 0; i < 4; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];

				if (tx < 0 || ty < 0 || tx >= n || ty >= n) continue;
				if (maze[tx][ty] == 1 && !temp.day) { // 벽을 만났을 때 낮이면 x
					continue;
				}
				
				int ttx = tx, tty = ty;
				boolean b = false;
				if (maze[tx][ty] == 1 && temp.day) { // 밤이면
					while(true) {
						ttx += dx[i];
						tty += dy[i];
						
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
				
				int cnt = temp.cnt, moon = temp.moon, sun = temp.sun;
				boolean day = temp.day;
				if(cnt == m) {
					day = !day;
					cnt = 1;
					if(day) moon++;
					else sun++;
				} else {
					cnt++;
				}
				if((visited[tx][ty][day ? 0 : 1] & (1 << cnt)) > 0) continue;
				visited[tx][ty][day ? 0 : 1] = (visited[tx][ty][day ? 0 : 1]) | (1 << cnt);
				Point next = new Point(tx, ty, sun, moon, cnt, day);
				q.add(next);
			}
		}
		if(!check) System.out.println(-1);

	}

	static class Point {
		int x, y, sun, moon, cnt;
		boolean day; // 낮 ; false, 밤 ; true

		public Point(int x, int y, int sun, int moon, int cnt, boolean day) {
			this.x = x;
			this.y = y;
			this.sun = sun;
			this.moon = moon;
			this.cnt = cnt;
			this.day = day;
		}

	}
}
