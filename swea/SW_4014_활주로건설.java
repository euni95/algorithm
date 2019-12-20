import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_4014_활주로건설 {
	static int N, X;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			aa : for(int i = 0; i < N; i++) {
				boolean[] v = new boolean[N];
				for(int j = 0; j < N - 1; j++) {
					int x = map[i][j], y = map[i][j+1];
					if(Math.abs(x - y) > 1) continue aa;
					if(x == y) continue;
					if(x < y) { // 오르막
						if(j - X + 1 < 0) continue aa;
						for(int k = 0; k < X; k++) {
							if((map[i][j-k] != map[i][j]) || v[j-k]) continue aa;
						}
						for(int k = 0; k < X; k++) {
							v[j-k] = true;
						}
					} else { // 내리막
						if(j + X >= N) continue aa;
						for(int k = 1; k < X + 1; k++) {
							if((map[i][j + 1] != map[i][j + k]) || v[j+k]) continue aa;
						}
						for(int k = 1; k < X + 1; k++) {
							v[j+k] = true;
						}
					}
				}
//				System.out.println(i);
				result++;
			}
			
			aa : for(int i = 0; i < N; i++) {
				boolean[] v = new boolean[N];
				for(int j = 0; j < N - 1; j++) {
					int x = map[j][i], y = map[j+1][i];
					if(Math.abs(x - y) > 1) continue aa;
					if(x == y) continue;
					if(x < y) { // 오르막
						if(j - X + 1 < 0) continue aa;
						for(int k = 0; k < X; k++) {
							if((map[j-k][i] != map[j][i]) || v[j-k]) continue aa;
						}
						for(int k = 0; k < X; k++) {
							v[j-k] = true;
						}
					} else { // 내리막
						if(j + X >= N) continue aa;
						for(int k = 1; k < X + 1; k++) {
							if((map[j + 1][i] != map[j + k][i]) || v[j+k]) continue aa;
						}
						for(int k = 1; k < X + 1; k++) {
							v[j+k] = true;
						}
					}
				}
//				System.out.println(i);
				result++;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}

}
