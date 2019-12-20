import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1953_탈주범검거 {
	static int N, M, R, C, L;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 지하 터널 지도 크기
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// 맨홀 뚜껑 위치
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			// 경과된 시간
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			result = 1;
			bfs();
			System.out.println("#" + t + " " + result);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int result;

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(R);
		q.add(C);
		visited[R][C] = true;

		int qSize, x = 0, y = 0, cnt = 1;
		while (!q.isEmpty()) {
			if (cnt == L) break;
			
			qSize = q.size()/2;
			
			for (int i = 0; i < qSize; i++) {
				x = q.poll();
				y = q.poll();

				boolean[] dir = new boolean[4];

				switch (map[x][y]) {
				case 1:
					dir[0] = true;
					dir[1] = true;
					dir[2] = true;
					dir[3] = true;
					break;
				case 2:
					dir[0] = true;
					dir[1] = true;
					break;
				case 3:
					dir[2] = true;
					dir[3] = true;
					break;
				case 4:
					dir[0] = true;
					dir[3] = true;
					break;
				case 5:
					dir[1] = true;
					dir[3] = true;
					break;
				case 6:
					dir[1] = true;
					dir[2] = true;
					break;
				case 7:
					dir[0] = true;
					dir[2] = true;
					break;
				}

				for (int j = 0; j < 4; j++) {
					if (dir[j]) {
						int tx = x + dx[j];
						int ty = y + dy[j];

						if (tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
						if (visited[tx][ty] || map[tx][ty] == 0) continue;
						

						int temp = map[tx][ty];
						boolean check = false;

						if (temp == 1) check = true;
						else if (j == 0) {
							if (temp == 2 || temp == 5 || temp == 6) check = true;
						}
						else if (j == 1) {
							if (temp == 2 || temp == 4 || temp == 7) check = true;
						}
						else if (j == 2) {
							if (temp == 3 || temp == 4 || temp == 5) check = true;
						}
						else {
							if (temp == 3 || temp == 6 || temp == 7) check = true;
						}

						if (check) {
							q.add(tx);
							q.add(ty);
							visited[tx][ty] = true;
							result++;
						}
						
					}
				}
			}
			cnt++;
		}
	}
}
