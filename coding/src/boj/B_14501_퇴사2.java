import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14501_퇴사2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;

		int N = Integer.parseInt(br.readLine());

		int[] days = new int[N + 1];
		int[] prices = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			stz = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(stz.nextToken());
			prices[i] = Integer.parseInt(stz.nextToken());
		}

		br.close();

		int[] dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			int tmp = i + days[i];
			System.out.println("tmp :: " + tmp);
			int max = 0;

			if (tmp <= N + 1) {
				for (int j = 1; j <= i; j++) {
					if (max < dp[j]) {
						System.out.println("max = " + max + " dp[j] = " + dp[j] );
						max = dp[j];
					}
				}
				System.out.println("max = " + max);
				System.out.println();
				dp[tmp] = Math.max(dp[tmp], max + prices[i]);
				System.out.println(Arrays.toString(dp));
			}
		}
		System.out.println(Arrays.toString(dp));

		int max = 0;

		for (int i = 1; i <= N + 1; i++) {
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}

}
