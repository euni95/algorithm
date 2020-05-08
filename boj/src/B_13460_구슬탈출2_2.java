import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13460_구슬탈출2_2 {
	static int move = 10;
	static int N, M, rx, ry, bx, by;
	static Point red, blue;
	static char[][] map;
	static boolean visited[][][][];
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'B') blue = new Point(i, j);
				else if (map[i][j] == 'R') red = new Point(i, j);
			}
		}

		Queue<Point> q = new LinkedList<>();
		q.add(red);
		q.add(blue);

		int cnt = 1;
		
		exit : while (!q.isEmpty()) {
			if(cnt == 11) break;
			int qSize = q.size() / 2;
			for (int i = 0; i < qSize; i++) {
				Point tr = q.poll();
				Point tb = q.poll();
				
				for (int j = 0; j < 4; j++) {
					rx = tr.x;
					ry = tr.y;
					bx = tb.x;
					by = tb.y;

					// 좌우일 땐(2, 3) x비교, 상하일 땐(0, 1) y비교
					int order = 0; // 0: r먼저, 1: b먼저
					if ((j == 0 && ry == by && bx < rx) || (j == 1 && ry == by && bx > rx)
							|| (j == 2 && rx == bx && by < ry) || (j == 3 && rx == bx && by > ry)) {
						order = 1;
					}
					
					isMove = 0;
					r = false;
					b = false;
					if (order == 0) {
						move(j, 0);
						move(j, 1);
					} else {
						move(j, 1);
						move(j, 0);
					}
					
					if(r & !b) {
						isExit = true;
						break exit;
					}
					if(isMove == 0 || b) continue;
					
					if(visited[rx][ry][bx][by]) continue;
					visited[rx][ry][bx][by] = true;
					q.add(new Point(rx, ry));
					q.add(new Point(bx, by));
				}
			}
			cnt++;
		}
		System.out.println(isExit ? cnt : -1);
	}
	
	static int isMove;
	static boolean r, b, isExit;
	private static void move(int dir, int color) {
		if (color == 0) {
			while (true) {
				if (rx < 0 || ry < 0 || rx >= N || ry >= M || map[rx][ry] == '#' || (rx == bx && ry == by)) {
					rx -= dx[dir];
					ry -= dy[dir];
					isMove--;
					break;
				}
				if(map[rx][ry] == 'O') {
					r = true;
					rx = -1;
					ry = -1;
					break;
				}
				rx += dx[dir];
				ry += dy[dir];
				isMove++;
			}
		} else {
			while (true) {
				if (bx < 0 || by < 0 || bx >= N || by >= M || map[bx][by] == '#' ||  (rx == bx && ry == by)) {
					bx -= dx[dir];
					by -= dy[dir];
					isMove--;
					break;
				}
				if(map[bx][by] == 'O') {
					b = true;
					bx = -1;
					by = -1;
					break;
				}
				bx += dx[dir];
				by += dy[dir];
				isMove++;
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
