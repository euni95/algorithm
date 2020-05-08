import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15684_사다리조작_X {
	static int N, M, H;
	static boolean[][] ladder;
	static int[] dx = { 0, 0, 1 }, dy = { -1, 1, 0 };
	static ArrayList<Point> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로선의 개수
		M = Integer.parseInt(st.nextToken()); // 가로선의 개수
		H = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을 수 있는 위치의 개수

		ladder = new boolean[M + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ladder[a][b] = true;
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(ladder[i][j] ? "1 " : "0 ");
			}
			System.out.println();
		}

		// 그을 수 있는 곳 구하기
		list = new ArrayList<>();
		boolean before = false;
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j < N; j++) {
				if(!before && !ladder[i][j] && !ladder[i][j+1]) list.add(new Point(i, j));
				before = ladder[i][j];
			} 
		}
		System.out.println(list);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
