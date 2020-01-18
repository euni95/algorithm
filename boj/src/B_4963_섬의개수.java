
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4963_섬의개수 {
	static int w, h;
	static int[][] island;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;

			island = new int[w][h];
			visited = new boolean[w][h];
			
			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < h; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					if (!visited[i][j] && island[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			for(int i = 0; i < 8; i++) {
				x = temp.x + dx[i];
				y = temp.y + dy[i];
				
				if(x < 0 || y < 0 || x >= w || y >= h) continue;
				if(visited[x][y] || island[x][y] != 1) continue;
				
				visited[x][y] = true;
				q.add(new Point(x, y));
			}
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
