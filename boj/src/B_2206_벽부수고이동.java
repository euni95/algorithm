import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2206_벽부수고이동 {
	static int N, M;
	static int[][] map;
	static int movePoint = 1;
	static class Point {
		int x;
		int y;
		int crack;

		public Point(int x, int y, int crack) {
			this.x = x;
			this.y = y;
			this.crack = crack;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = line[j - 1] - '0';
			}
		}
		if(N == 1 && M == 1 && map[1][1] == 0) {
			System.out.println(1);
			return;
		}
		Point start = new Point(1, 1, 0);
		move(start);
		if(check) System.out.println(movePoint);
		else System.out.println(-1);
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean check;
	private static void move(Point p) {
		Queue<Point> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N + 1][M + 1][2];
		q.add(new Point(p.x,p.y, p.crack));
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for(int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				int x = temp.x;
				int y = temp.y;
				int crack = temp.crack;
				
				for(int j = 0; j < 4; j++) {
					int tx = x + dx[j];
					int ty = y + dy[j];
					
					if(tx <= 0 || ty <= 0 || tx > N || ty > M) continue;
					if(visited[tx][ty][crack] == true) continue;
					if(crack == 0 && map[tx][ty] == 1) {		
						if(tx == N && ty == M) {
							movePoint++;
							check = true;
							return;
						}
						visited[tx][ty][crack + 1] = true;
						q.add(new Point(tx, ty, crack + 1));
					}
					if(map[tx][ty] == 0) {
						if(tx == N && ty == M) {
							movePoint++;
							check = true;
							return;
						}
						visited[tx][ty][crack] = true;
						q.add(new Point(tx, ty, crack));
					}
				}
			}
			movePoint++;
		}
	}

}
