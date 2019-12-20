import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4301_콩많이심기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[][] field = new int[N][M];
			int[] dx = { -2, 2, 0, 0 };
			int[] dy = { 0, 0, -2, 2 };
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					field[i][j] = 1;
					cnt++;
					for (int d = 0; d < 4; d++) {
						int tx = i + dx[d];
						int ty = j + dy[d];

						if (tx < 0 || ty < 0 || tx >= N || ty >= M)
							continue;
						if (field[tx][ty] == 1) {
							field[i][j] = 0;
							cnt--;
							break;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
