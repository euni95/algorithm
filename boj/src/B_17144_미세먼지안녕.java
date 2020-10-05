import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17144_미세먼지안녕 {
	static int R, C, T, c, r;
	static int[] air, dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		c = C - 1;
		r = R - 1;
		map = new int[R][C];
		air = new int[2];
		int idx = 0;
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) air[idx++] = i;
			}
		}
		
		diffusion();
		
		int dust = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue;
				dust += map[i][j];
			}
		}
		System.out.println(dust);
	}

	private static void diffusion() {
		for(int t = 0; t < T; t++) {
			int[][] dustSum = new int[R][C];

			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] < 1) continue;
					int dust = map[i][j] / 5;
					int cnt = 0;
						
					for(int k = 0; k < 4; k++) {
						int tx = i + dx[k];
						int ty = j + dy[k];
							
						if(tx < 0 || ty < 0 || tx >= R || ty >= C) continue;
						if(map[tx][ty] == -1) continue;
						dustSum[tx][ty] += dust;
						cnt++;
					}
					dustSum[i][j] += map[i][j] - dust * cnt;
				}
			}
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(dustSum[i][j] > 0) {
						map[i][j] = dustSum[i][j];
						dustSum[i][j] = 0;
					}
				}
			}
			circulation();
		}

	}
	
	private static void circulation() {
		int x = air[0];
		for(int i = x - 1; i > 0; i--) map[i][0] = map[i - 1][0];
		for(int i = 0; i < c; i++) map[0][i] = map[0][i + 1];
		for(int i = 0; i < x; i++) map[i][c] = map[i + 1][c];
		for(int i = c; i > 1; i--) map[x][i] = map[x][i - 1];
		map[x][1] = 0;
		
		x = air[1];
		for(int i = x + 1; i < r; i++) map[i][0] = map[i + 1][0];
		for(int i = 0; i < c; i++) map[r][i] = map[r][i + 1];
		for(int i = r; i > x; i--) map[i][c] = map[i - 1][c];
		for(int i = c; i > 1; i--) map[x][i] = map[x][i - 1];
		map[x][1] = 0;
	}

}
