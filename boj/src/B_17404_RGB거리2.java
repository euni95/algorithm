import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17404_RGB거리2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][3];
		int[][] cost = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) cost[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1000 * N;
		int min = max;
		for(int i = 0; i < 3; i++) { // 첫 번째 집을 결정
			Arrays.fill(dp[0], max); //결정한 집을 제외한 곳엔 max값 삽입
			dp[0][i] = cost[0][i];
			
			for(int j = 1; j < N; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + cost[j][2];
			}
			
			for(int j = 0; j < 3; j++) {
				if(j == i) continue;
				min = Math.min(min, dp[N - 1][j]);
			}
		}
		System.out.println(min);
	}
}
