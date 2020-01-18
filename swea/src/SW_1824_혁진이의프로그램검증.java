import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1824_혁진이의프로그램검증 {
	static int R, C;
	static char[][] program;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean check;
	static boolean[][][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			program = new char[R][C];

			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				if(line.contains("@")) check = true;
				program[i] = line.toCharArray();
			}
			if (check) {
				check = false;
				Queue<Point> q = new LinkedList<>();
				visited = new boolean[R][C][4][16];
				int x, y, dir, memory;
				int tx, ty;
				q.add(new Point(0, 0, 3, 0));

				loop: while (!q.isEmpty()) {
					Point temp = q.poll();

					dir = temp.dir;
					x = temp.x;
					y = temp.y;
					memory = temp.memory;

					if (visited[x][y][dir][memory]) continue;
					visited[x][y][dir][memory] = true;

					char pg = program[x][y];

					switch (pg) {

					case '@':
						check = true;
						break loop;
					case '<':
						dir = 2;
						break;
					case '>':
						dir = 3;
						break;
					case '^':
						dir = 0;
						break;
					case 'v':
						dir = 1;
						break;
					case '_':
						dir = (memory == 0 ? 3 : 2);
						break;
					case '|':
						dir = (memory == 0 ? 1 : 0);
						break;
					case '+':
						memory = (memory == 15 ? 0 : memory + 1);
						break;
					case '-':
						memory = (memory == 0 ? 15 : memory - 1);
						break;
					case '.':
					case '?':
						break;
					default:
						memory = pg - '0';
						break;
					}
					if (pg == '?') {
						for (int i = 0; i < 4; i++) {
							tx = x + dx[i];
							ty = y + dy[i];

							if (tx < 0) tx = R - 1;
							else if (tx >= R) tx = 0;
							
							if (ty < 0) ty = C - 1;
							else if (ty >= C) ty = 0;
							
							q.add(new Point(tx, ty, i, memory));
						}
					} else {
						tx = x + dx[dir];
						ty = y + dy[dir];

						if (tx < 0) tx = R - 1;
						else if (tx >= R) tx = 0;
						
						if (ty < 0) ty = C - 1;
						else if (ty >= C) ty = 0;
						q.add(new Point(tx, ty, dir, memory));
					}
				}
			}
			if (check) System.out.println("#" + t + " YES");
			else System.out.println("#" + t + " NO");
		}
	}

	static class Point {
		int x, y, dir, memory;

		public Point(int x, int y, int dir, int memory) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.memory = memory;
		}
	}
}
