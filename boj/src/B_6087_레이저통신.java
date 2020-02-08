import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_6087_레이저통신 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		char[][] map = new char[H][W];
		int[][][] visited = new int[H][W][4];
		boolean start = false;
		Point end = null;
		int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.mirror - o2.mirror;
			}
		});
		for (int i = 0; i < H; i++) {
			String temp = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = temp.charAt(j);
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
				if (map[i][j] == 'C') {
					if (!start) {
						for(int k = 0; k < 4; k++) q.add(new Point(i, j, 0, k));
						start = true;
					} else end = new Point(i, j, 0, 0);
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			if(temp.x == end.x && temp.y == end.y) {
				System.out.println(temp.mirror);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				if((temp.dir + 2) % 4 == i) continue;
				
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];
			
				if(tx < 0 || ty < 0 || tx >= H || ty >= W) continue;
				if(map[tx][ty] == '*') continue;
					
				int mirror = temp.mirror;
				if(temp.dir != i) mirror++;
				if(visited[tx][ty][i] <= mirror) continue;
				
				visited[tx][ty][i] = mirror;
				q.add(new Point(tx, ty, mirror, i));
			}
		}
	}

	static class Point {
		int x, y, mirror, dir;

		public Point(int x, int y, int mirror, int dir) {
			this.x = x;
			this.y = y;
			this.mirror = mirror;
			this.dir = dir;
		}

	}
}
