import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1003_피보나치함수 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[41];
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i < 41; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(Arrays.toString(dp));
		int n = 0;
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) sb.append("1 0\n");
			else sb.append(dp[n - 1]).append(" ").append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
}
