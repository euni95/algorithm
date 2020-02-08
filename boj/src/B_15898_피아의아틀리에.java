import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15898_피아의아틀리에 {
	static int n, max;
	static int[][][] quality;
	static char[][][] element;
	static int[][] pot_q;
	static char[][] pot_e;
	static Point[] pos = { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		quality = new int[n][4][4];
		element = new char[n][4][4];
		pot_q = new int[5][5];
		pot_e = new char[5][5];

		for (int i = 0; i < 5; i++) {
			Arrays.fill(pot_e[i], 'W');
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					quality[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < 4; j++) {
				String temp = br.readLine();
				for (int k = 0; k < 8; k += 2) {
					element[i][j][k / 2] = temp.charAt(k);
				}
			}
		}
		order = new int[3];
		dir = new int[3];
		start = new int[3];
		visited = new boolean[n];
		perm(0);
		System.out.println(max);
	}

	static int[] order, dir, start;
	static boolean[] visited;

	private static void perm(int depth) {
		if (depth == 3) {
			makeDir(0);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			order[depth] = i;
			perm(depth + 1);
			visited[i] = false;
		}
	}

	private static void makeDir(int depth) {
		if (depth == 3) {
			makeStart(0);
			return;
		}

		for (int i = 0; i < 4; i++) {
			dir[depth] = i;
			makeDir(depth + 1);
		}
	}

	private static void makeStart(int depth) {
		if (depth == 3) {
			for (int i = 0; i < 3; i++) {
				calc(i);
			}
			for (int i = 0; i < 5; i++) {
				Arrays.fill(pot_q[i], 0);
				Arrays.fill(pot_e[i], 'W');
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			start[depth] = i;
			makeStart(depth + 1);
		}
	}

	static void calc(int idx) {
		int t_x = pos[start[idx]].x;
		int t_dir = dir[idx];
		int t_order = order[idx];

		switch (t_dir) {
		case 0:
			for (int i = 0; i < 4; i++) {
				int t_y = pos[start[idx]].y;
				for (int j = 0; j < 4; j++) {
//						System.out.print(element[t_order][i][j] + " ");
					int t_q = pot_q[t_x][t_y] + quality[t_order][i][j];
					if (t_q < 0) pot_q[t_x][t_y] = 0;
					else if (t_q > 9) pot_q[t_x][t_y] = 9;
					else pot_q[t_x][t_y] = t_q;
					char t_e = element[t_order][i][j];
					if(t_e != 'W') pot_e[t_x][t_y] = t_e;
					t_y++;
				}
				t_x++;
			}
			break;
		case 1:
			for (int i = 3; i >= 0; i--) {
				int t_y = pos[start[idx]].y;
				for (int j = 0; j < 4; j++) {
//						System.out.print(element[t_order][j][i] + " ");
					int t_q = pot_q[t_x][t_y] + quality[t_order][j][i];
					if (t_q < 0) pot_q[t_x][t_y] = 0;
					else if (t_q > 9) pot_q[t_x][t_y] = 9;
					else pot_q[t_x][t_y] = t_q;
					char t_e = element[t_order][j][i];
					if(t_e != 'W') pot_e[t_x][t_y] = t_e;
					t_y++;
				}
				t_x++;
			}
			break;
		case 2:
			for (int i = 3; i >= 0; i--) {
				int t_y = pos[start[idx]].y;
				for (int j = 3; j >= 0; j--) {
//						System.out.print(element[t_order][i][j] + " ");
					int t_q = pot_q[t_x][t_y] + quality[t_order][i][j];
					if (t_q < 0) pot_q[t_x][t_y] = 0;
					else if (t_q > 9) pot_q[t_x][t_y] = 9;
					else pot_q[t_x][t_y] = t_q;
					char t_e = element[t_order][i][j];
					if(t_e != 'W') pot_e[t_x][t_y] = t_e;
					t_y++;
				}
				t_x++;
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				int t_y = pos[start[idx]].y;
				for (int j = 3; j >= 0; j--) {
//						System.out.print(element[t_order][j][i] + " ");
					int t_q = pot_q[t_x][t_y] + quality[t_order][j][i];
					if (t_q < 0) pot_q[t_x][t_y] = 0;
					else if (t_q > 9) pot_q[t_x][t_y] = 9;
					else pot_q[t_x][t_y] = t_q;
					char t_e = element[t_order][j][i];
					if(t_e != 'W') pot_e[t_x][t_y] = t_e;
					t_y++;
				}
				t_x++;
			}
			break;
		}
		
		int r = 0, b = 0, g = 0, y = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(pot_e[i][j] == 'R') r += pot_q[i][j];
				else if(pot_e[i][j] == 'B') b += pot_q[i][j];
				else if(pot_e[i][j] == 'G') g += pot_q[i][j];
				else if(pot_e[i][j] == 'Y') y += pot_q[i][j];
				
			}
		}
		
		max = Math.max(max, (r*7) + (5*b) + (3*g) + (2*y));
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
