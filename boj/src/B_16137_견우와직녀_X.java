import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16137_견우와직녀_X {
	static int N, M;
	static int[][] ground;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ground = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = ground[i][j];
				if (temp == 0) {
					int cliff = 0;
					exit: for (int k = 0; k < 5; k++) {
						int tx = i + dx[k % 4];
						int ty = j + dy[k % 4];
						if (tx < 0 || ty < 0 || tx >= N || ty >= N) {
							cliff--;
							continue;
						}
						if (ground[tx][ty] != 1) {
							cliff++;
							if (cliff == 2) {
								break exit;
							}
						} else
							cliff--;
					}
					if (cliff != 2) {
						ground[i][j] = M;
						go(i, j);
						ground[i][j] = 0;
					}
				}
			}
		}
		System.out.println(min);
	}

	static int min;

	private static void go(int x, int y) {
		boolean[][] visited = new boolean[N][N];
		visited[N - 1][N - 1] = true;
		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.min - o2.min;
			}
		});
		q.add(new Point(N - 1, N - 1, 0, false));
		int result = 0;
		exit : while (!q.isEmpty()) {
			Point temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];

				if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
				if(visited[tx][ty]) continue;
				if(tx == 0 && ty == 0) {
					System.out.println(temp.min);
					result = temp.min;
					break exit;
				}
				
				int current = ground[tx][ty];
				if(current == 0) continue;
				int t_min = 0;
				boolean t_cross = temp.cross;
				if(current != 1) {
					if(t_cross) continue;
					else t_cross = true;
					
					int rest = (temp.min + 1) % current;
					if(rest != 0) t_min = temp.min + current - rest;
				} else {
					t_cross = false;
					t_min = temp.min + 1;
				}
				visited[tx][ty] = true;
				q.add(new Point(tx, ty, t_min, t_cross));
			}

		}
		min = Math.min(result, min);
	}

	static class Point {
		int x, y, min;
		boolean cross;

		public Point(int x, int y, int min, boolean cross) {
			this.x = x;
			this.y = y;
			this.min = min;
			this.cross = cross;
		}

	}
}
