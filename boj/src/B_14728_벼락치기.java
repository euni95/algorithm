import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14728_벼락치기 {
	static int N, T, maxScore;
	static int[] K, S;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = new int[N+1];
		S = new int[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			K[i] = Integer.parseInt(st.nextToken()); // 공부 시간
			S[i] = Integer.parseInt(st.nextToken()); // 배점
		}
		dp = new int[N + 1][T + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= T; j++) {
				if(j >= K[i]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - K[i]] + S[i]);
				} else dp[i][j] = dp[i - 1][j];
			}
		}
		
		int[] test = new int[T + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = T; j >= K[i]; j--) {
				if(test[j] < test[j - K[i]] + S[i]) {
					System.out.printf("test[%d] = %d, test[%d - K[%d]] + S[%d] = %d\n", j, test[j], j, i, i, test[j - K[i]] + S[i]);
					test[j] = test[j - K[i]] + S[i];
				}
			}
		}
		
		System.out.println(Arrays.toString(test));
		System.out.println(dp[N][T]);
	}



}
