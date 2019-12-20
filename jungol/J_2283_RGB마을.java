import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J_2283_RGB마을 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][N];
		int[][] dp = new int [N][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0) dp[i][j] = cost[i][j];
				else {
					int min = Integer.MAX_VALUE;
					for(int k = 0; k < 3; k++) {
						if(k == j) continue;
						min = Math.min(min, dp[i-1][k]);
					}
					dp[i][j] = cost[i][j] + min;
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) result = Math.min(dp[N-1][i], result);
		System.out.println(result);
	}

}
