import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14503_로봇청소기 {
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 }; // 북동남서

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		int[][] place = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 1;
		place[x][y] = -1;

		clean : while (true) {
			for (int i = 0; i < 4; i++) {
				dir = (dir + 3) % 4;
				int tx = x + dx[dir];
				int ty = y + dy[dir];
				
				if (place[tx][ty] == 0) {
					place[tx][ty] = -1;
					cnt++;
					x = tx; y = ty;
					continue clean;
				}
			}
			x -= dx[dir]; y -= dy[dir];
			if (place[x][y] == 1) break;
		}
		System.out.println(cnt);
	}

}
