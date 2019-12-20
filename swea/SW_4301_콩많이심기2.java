import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_4301_콩많이심기2 {
	static int N, M;
	static int[][] map;
	static int[] dx = { -2, 2, 0, 0 }, dy = { 0, 0, -2, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			int cnt = N * M;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						for(int k = 0; k < 4; k++) {
							int tx = i + dx[k];
							int ty = j + dy[k];
							
							if(tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
							if(map[tx][ty] == 0) {
								map[tx][ty] = -1;
								cnt--;
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
