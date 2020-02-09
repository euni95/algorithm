import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17406_배열돌리기4 {
	static int N, M, K, MIN = Integer.MAX_VALUE;
	static int[][] arr, original_arr;
	static int[] order;
	static boolean[] visited;
	static Point[] pos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		original_arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				original_arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pos = new Point[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			pos[i] = new Point(r, c, s);
		}
		
		order = new int[K];
		visited = new boolean[K];
		
		makeOrder(0);
		System.out.println(MIN);
	}

	private static void makeOrder(int idx) {
		if(idx == K) {
			for(int i = 0; i < N; i++) {
				System.arraycopy(original_arr[i], 0, arr[i], 0, M);
			}
			calc();
			return;
		}
		for(int i = 0; i < K; i++) {
			if(visited[i]) continue;
			order[idx] = i;
			visited[i] = true;
			makeOrder(idx + 1);
			visited[i] = false;
		}
	}

	private static void calc() {
		for(int i = 0; i < K; i++) {
			Point temp = pos[order[i]];
			int sx = temp.r - temp.s - 1, sy = temp.c - temp.s - 1;
			int ex = temp.r + temp.s - 1, ey = temp.c + temp.s - 1;

			while (sx != ex) {
				rotation(sx, sy, ex, ey);
				sx++; sy++;
				ex--; ey--;
			}
		}
		
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				sum += arr[i][j];
			}
			MIN = Math.min(MIN, sum);
		}
	}

	private static void rotation(int sx, int sy, int ex, int ey) {
		int start = arr[sx][sy];

		// 좌
		for (int i = sx + 1; i <= ex; i++) {
			arr[i - 1][sy] = arr[i][sy];
		}

		// 하
		for (int i = sy + 1; i <= ey; i++) {
			arr[ex][i - 1] = arr[ex][i];
		}

		// 우
		for (int i = ex - 1; i >= sx; i--) {
			arr[i + 1][ey] = arr[i][ey];
		}

		// 상
		for (int i = ey - 1; i > sy; i--) {
			arr[sx][i + 1] = arr[sx][i];
		}
		arr[sx][sy + 1] = start;
	}

	static class Point {
		int r, c, s;

		public Point(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

	}
}
