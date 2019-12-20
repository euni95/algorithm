import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2105_디저트카페 {
	static int N;
	static int[][] cafe;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[101];
					startX = i;
					startY = j;
					dessert(i, j, 1, 0, 0);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}

	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { -1, 1, 1, -1 };
	static boolean[] visited;
	static int max;
	static int startX, startY;
	private static void dessert(int x, int y, int len, int dir, int cnt) {
//		if(cnt > 4) return;
		visited[cafe[x][y]] = true;
		for(int i = 0; i < 2; i++) {
			if(dir == 3 && i == 1) continue;
			int tx = x + dx[dir + i];
			int ty = y + dy[dir + i];
			
			if(tx == startX && ty == startY && len >= 4) {
				max = Math.max(max, len);
				break;
			}
			if(tx < 0 || ty < 0 || tx >= N || ty >= N || visited[cafe[tx][ty]]) continue;
			dessert(tx, ty, len + 1, dir + i, cnt + i);
		}
		visited[cafe[x][y]] = false;
	} 


}
