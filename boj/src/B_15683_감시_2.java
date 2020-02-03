import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15683_감시_2 {
	static int N, M, deadzone, min;
	static int[] order;
	static int[][] office;
	static ArrayList<Point> cctv;
	static int[][] dir = { {}, { 1, 2, 4, 8 }, { 5, 10 }, { 3, 6, 12, 9 }, { 7, 14, 13, 11 }, { 15 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		cctv = new ArrayList<>();
		min = N * M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] <= 5 && office[i][j] >= 1) cctv.add(new Point(i, j, office[i][j]));
				else if(office[i][j] == 0) deadzone++;
			}
		}
		order = new int[cctv.size()];
		perm(0);
		System.out.println(min);
	}


	private static void perm(int idx) {
		if(idx == cctv.size()) {
			go();
			return;
		}
			int temp = cctv.get(idx).dir;
			int limit = 4;
			if(temp == 2) limit = 2;
			else if(temp == 5) limit = 1;
			
			for(int i = 0; i < limit; i++) {
				order[idx] = dir[temp][i];
				perm(idx + 1);
			}
	}
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; // 상, 우, 하, 좌
	private static void go() {
		boolean[][] visited = new boolean[N][M];
		int dz_temp = deadzone;
		
		for(int i = 0; i < cctv.size(); i++) {
			Point temp = cctv.get(i);
			for(int j = 0; j < 4; j++) {
				if(((1 << j) & order[i]) > 0) {
					int tx = temp.x;
					int ty = temp.y;

					while(true) {
						tx += dx[j];
						ty += dy[j];
						
						if(tx < 0 || ty < 0 || tx >= N || ty >= M) break;
						if(office[tx][ty] == 6) break;
						if(office[tx][ty] == 0 && !visited[tx][ty]) {
							dz_temp--;
							visited[tx][ty] = true;
						}
					}
				}
			}
		}
		min = Math.min(min, dz_temp);
	}

	static class Point {
		int x, y, dir;

		public Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}
}
