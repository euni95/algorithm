import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J_1082_화염에서탈출 {
	static int R, C;
	static int[][] map;
	static Point start, end;
	static Queue<Point> fire, move;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		fire = new LinkedList<>();
		move = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j) == 'D') {
					end = new Point(i, j);
					map[i][j] = -2;
				} else if (line.charAt(j) == 'S') {
					start = new Point(i, j);
					move.add(new Point(i, j));
					map[i][j] = 0;
				} else if (line.charAt(j) == '*') {
					fire.add(new Point(i, j));
					map[i][j] = 1;
				} else if (line.charAt(j) == 'X') {
					map[i][j] = -1;
				}
			}
		}

		result = "impossible";

		while (!fire.isEmpty()) {
			Point temp = fire.poll();
			int cnt = map[temp.x][temp.y];

			for (int j = 0; j < 4; j++) {
				int tx = temp.x + dx[j];
				int ty = temp.y + dy[j];

				if (tx < 0 || ty < 0 || tx >= R || ty >= C)
					continue;
				if (map[tx][ty] == 0) {
					map[tx][ty] = cnt + 1;
					fire.add(new Point(tx, ty));
				}
			}
		}

		map[start.x][start.y] = 1;
		exit: while (!move.isEmpty()) {
			Point temp = move.poll();
			int cnt = map[temp.x][temp.y];

			for (int j = 0; j < 4; j++) {
				int tx = temp.x + dx[j];
				int ty = temp.y + dy[j];

				if (tx < 0 || ty < 0 || tx >= R || ty >= C)
					continue;
				if (map[tx][ty] == -2) {
					result = String.valueOf(cnt);
					break exit;
				}
				if (map[tx][ty] > cnt + 1 || map[tx][ty] == 0) {

					map[tx][ty] = cnt + 1;
					move.add(new Point(tx, ty));
				}
			}
		}
		System.out.println(result);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
