package study_190821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2567_색종이2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int paperNum = Integer.parseInt(br.readLine());

		int[][] paper = new int[102][102];
		for (int i = 0; i < paperNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int cnt = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (paper[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						if (paper[i + dx[k]][j + dy[k]] == 0) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
