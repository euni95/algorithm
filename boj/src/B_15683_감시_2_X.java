import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15683_감시_2_X {
	static int N, M;
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
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] <= 5 && office[i][j] >= 1)
					cctv.add(new Point(i, j, office[i][j]));
			}
		}
		order = new int[cctv.size()];
		dfs(0);
	}

	static int[] order;

	private static void dfs(int idx) {
		if(idx == cctv.size()) {
			System.out.println(Arrays.toString(order));
			return;
		}
			int temp = cctv.get(idx).dir;
			int limit = 4;
			if(temp == 2) limit = 2;
			else if(temp == 5) limit = 1;
			
			for(int i = 0; i < limit; i++) {
				order[idx] = dir[temp][i];
				dfs(idx + 1);
			}
	}

	static class Point {
		int x, y, dir;

		public Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}

	}
}
