import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1258_행렬찾기 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						find(i, j);
						cnt++;
					}

				}
			}
			System.out.print("#" + t + " " + cnt + " ");
			Collections.sort(list, new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					int mul1 = o1.x * o1.y;
					int mul2 = o2.x * o2.y;
					if(mul1 == mul2) return o1.x - o2.x;					
					return mul1 - mul2;
				}
			});
			for (Point p : list) {
				System.out.print(p.x + " " + p.y + " ");
			}
			System.out.println();

		}
	}

	static ArrayList<Point> list;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };
	static int xx, yy;

	private static void find(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		xx = 0;
		yy = 0;
		while (!q.isEmpty()) {
			Point temp = q.poll();

			for (int i = 0; i < 2; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];

				if (tx < 0 || ty < 0 || tx >= N || ty >= N)
					continue;
				if (map[tx][ty] == 0)
					continue;
				map[tx][ty] = 0;
				q.add(new Point(tx, ty));
				xx = tx + 1;
				yy = ty + 1;
			}
		}

		list.add(new Point(xx - x, yy - y));
	}

	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return this.x < o.x ? 1 : -1;
		}

	}
}
