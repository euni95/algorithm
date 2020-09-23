import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1949_등산로조성 {
	static int N, K, maxLength;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 한 변의 길이
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			map = new int[N][N];
			maxLength = 0;
			int max = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						makePoint(i, j);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(maxLength).append("\n");
		}
		System.out.println(sb);
	}

	private static void makePoint(int x, int y) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == x && j == y) continue;
				
				int temp = map[i][j];
				for(int k = 0; k < K; k++) {
					map[i][j]--;
					if(map[i][j] < 0) break;
					findTrail(x, y, map[x][y], 1);
				}
				map[i][j] = temp;
			}
		}
	}
	
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	private static void findTrail(int x, int y, int height, int length) {
		maxLength = Math.max(maxLength, length);
		
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
			if(map[tx][ty] >= height) continue;
			
			findTrail(tx, ty, map[tx][ty], length + 1);
		}
	}
}