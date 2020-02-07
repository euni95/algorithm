import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17070_파이프옮기기1 {
	static int N, result;
	static int[][] home;
	static int[][][][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N][N];
		dp = new int[N][N][N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}
		dfs(0, 0, 0, 1);
		System.out.println(dp[0][0][0][1]);
	}

	private static int dfs(int sx, int sy, int ex, int ey) {
		if(sx < 0 || sy < 0 || ex < 0 || ey < 0) return 0;
		if(sx >= N || sy >= N || ex >= N || ey >= N) return 0;
		if((sx != ex && sy != ey) && (home[sx][sy+1] == 1 || home[sx+1][sy] == 1)) return 0;
		if(home[sx][sy] == 1 || home[ex][ey] == 1) return 0;
		if(dp[sx][sy][ex][ey] != -1) return dp[sx][sy][ex][ey];
		if(ex == N - 1 && ey == N - 1) {
			return 1;
		}
		dp[sx][sy][ex][ey] = 0;
		int t_sx = ex, t_sy = ey, t_ex = ex, t_ey = ey;
		// 가로 방향일 때
		if(sx == ex) {
			t_ey = ey + 1;
			dp[sx][sy][ex][ey] += dfs(t_sx, t_sy, t_ex, t_ey);
			
			t_ex = ex + 1;
			dp[sx][sy][ex][ey] += dfs(t_sx, t_sy, t_ex, t_ey);
		}
		// 세로 방향일 때
		else if(sy == ey) {
			t_ex = ex + 1;
			dp[sx][sy][ex][ey] += dfs(t_sx, t_sy, t_ex, t_ey);
			
			t_ey = ey + 1;
			dp[sx][sy][ex][ey] += dfs(t_sx, t_sy, t_ex, t_ey);
		}
		// 대각선 방향일 때
		else {
			t_ey = ey + 1;
			dp[sx][sy][ex][ey] += dfs(t_sx, t_sy, t_ex, t_ey);
			
			t_ex = ex + 1;
			t_ey = ey;
			dp[sx][sy][ex][ey] += dfs(t_sx, t_sy, t_ex, t_ey);
			
			t_ey = ey + 1;
			dp[sx][sy][ex][ey] += dfs(t_sx, t_sy, t_ex, t_ey);
		}
		return dp[sx][sy][ex][ey];
	}

}
