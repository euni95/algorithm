import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2098_외판원순회 {
	static int N;
	static int[][] city;
	static int[][] dp;
	static final int INF = 100000000;
	static final int START = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][1 << N];
		city = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		for(int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
		
		System.out.println(trip(START, 1 << START));
	}
	
	private static int trip(int cur, int B) {
		if(dp[cur][B] != -1) return dp[cur][B];
		if(B == (1 << N) - 1) {
			return dp[cur][B] = city[cur][START] != 0 ? city[cur][START] : INF;
		}
		dp[cur][B] = INF;
		for(int i = 0; i < N; i++) {
			if(city[cur][i] == 0 || (B & (1 << i)) > 0) {
				continue;
			}
			dp[cur][B] = Math.min(dp[cur][B], trip(i, (B | (1 << i))) + city[cur][i]);
		}
		return dp[cur][B];
	}
}
