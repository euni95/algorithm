import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17244_아맞다우산 {
	static int N, M, number, min;
	static int[][] home, len;
	static Point S, E;
	static ArrayList<Point> things;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 }, order;
	static boolean[] oV;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로길이
		M = Integer.parseInt(st.nextToken()); // 세로길이
		home = new int[M][N];
		things = new ArrayList<>();
		number = 0;
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				char ch = temp.charAt(j);

				if (ch == '#') {
					home[i][j] = -1;
				} else if (ch == 'S') {
					S = new Point(i, j);
				} else if (ch == 'E') {
					E = new Point(i, j);
				} else if (ch == 'X') {
					things.add(new Point(i, j));
					number++;
				}
			}
		}
		
		len = new int[number + 2][number + 2];
		for (int i = 0; i <= number + 1; i++) {
			for (int j = i + 1; j <= number + 1; j++) {
				getDist(i, j);
			}
		}
		
		order = new int[number];
		oV = new boolean[number + 1];
		min = Integer.MAX_VALUE;
		makeOrder(0);
		System.out.println(min);
	}

	
	private static void makeOrder(int cnt) {
		if(cnt == number) {
			calc();
			return;
		}
		
		for(int i = 1; i <= number; i++) {
			if(oV[i]) continue;
			oV[i] = true;
			order[cnt] = i;
			makeOrder(cnt + 1);
			oV[i] = false;
		}
	}
	
	private static void calc() {
		int sum = 0;
		
		if(order.length == 0) {
			sum += len[0][1];
		}
		else {
			sum = len[0][order[0]]; // start지점에서 첫번째물건까지
			for(int i = 0; i < order.length - 1; i++) {
				sum += len[order[i]][order[i+1]];
			}
			sum += len[order[order.length - 1]][number + 1];
		}
		min = Math.min(sum, min);
	}

	private static void getDist(int sIdx, int eIdx) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[M][N];
		Point s = null, e = null;
		if (sIdx == 0) {
			s = S;
		} else {
			s = things.get(sIdx - 1);
		}
		if (eIdx == number + 1) {
			e = E;
		} else {
			e = things.get(eIdx - 1);
		}
		
		q.add(s);
		visited[s.x][s.y] = true;
		int cnt = 0;
		boolean check = false;
		exit: while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				for (int j = 0; j < 4; j++) {
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];

					if (tx < 0 || ty < 0 || tx >= M || ty >= N) continue;
					if (visited[tx][ty] || home[tx][ty] == -1) continue;
					if (tx == e.x && ty == e.y) {
						check = true;
						break exit;
					}

					visited[tx][ty] = true;
					q.add(new Point(tx, ty));
				}
			}
			cnt++;
		}

		if (check) {
			len[sIdx][eIdx] = cnt + 1;
			len[eIdx][sIdx] = cnt + 1;
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
