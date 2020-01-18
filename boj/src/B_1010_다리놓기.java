import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B_1010_다리놓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			BigInteger[][] dp = new BigInteger[n + 1][m + 1];

			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= m; j++) {
					dp[i][j] = BigInteger.ZERO;
				}
			}
			dp[1][0] = BigInteger.valueOf(1);
			dp[1][1] = BigInteger.valueOf(1);

			for (int i = 2; i <= n; i++) {
				dp[i][0] = BigInteger.valueOf(1);

				for (int j = 1; j <= m; j++) {
					dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
				}
			}
			System.out.println(dp[n][m]);
		}
	}
}
