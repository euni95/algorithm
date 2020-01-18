import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_10026_적록색약 { // 190812_적록색약
	static char[][] grid;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		for (int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();
		}

		int color = 0;
		int color_2 = 0;
		char c;
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					test(grid[i][j], i, j, visited, 0);
					color++;
					
				}
			}
		}
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					if(grid[i][j] == 'G') c = 'R';
					else c = grid[i][j];
					test(c, i, j, visited, 1);
					color_2++;
					
				}
			}
		}
		System.out.println(color + " " + color_2);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void test(char c, int x, int y, boolean[][] visited, int check) {
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if (tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
			
			char temp = grid[tx][ty];
			if(check == 1 && temp == 'G') temp = 'R';
			if (visited[tx][ty] || temp != c) continue;
			visited[tx][ty] = true;
			test(c, tx, ty, visited, check);
		}
	}

}
