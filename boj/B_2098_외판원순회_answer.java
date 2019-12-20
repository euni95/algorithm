import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2098_외판원순회_answer {
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
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1);

		System.out.println(trip(START, 1 << START));
	}

	private static int trip(int cur, int B) {
		// 방문해서 저장되어 있던 그 값을 재활용(메모이제이션)
		if (dp[cur][B] != -1)
			return dp[cur][B];

		// 마지막 도시까지 다 방문한 경우
		if (B == (1 << N) - 1) {
			return dp[cur][B] = city[cur][START] != 0 ? city[cur][START] : INF;
		}

		// 방문할 도시 체크 배열 최대값으로 초기화
		dp[cur][B] = INF;
		for (int i = 0; i < N; i++) {
			// 갈 수 없으면 무시 || 방문 했던 도시이면
			if (city[cur][i] == 0 || (B & (1 << i)) > 0) {
				continue;
			}

			// 새로운 도시를 거쳐서 가능 비용이 더 저렴하면 현재 비용을 수정함
			dp[cur][B] = Math.min(dp[cur][B], trip(i, (B | (1 << i))) + city[cur][i]);
		}
		return dp[cur][B];
	}
}
