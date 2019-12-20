import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1266_소수완제품확률 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] prime = { 2, 3, 5, 7, 11, 13, 17 };
		int[] combi = { 153, 816, 8568, 31824, 31824, 8568, 18};

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken()) / 100.0;
			double b = Double.parseDouble(st.nextToken()) / 100.0;

			double tempA = 0;
			double tempB = 0;
			for (int i = 0; i < 7; i++) {
				tempA += combi[i] * Math.pow(a, prime[i]) * Math.pow(1 - a, 18 - prime[i]);
				tempB += combi[i] * Math.pow(b, prime[i]) * Math.pow(1 - b, 18 - prime[i]);
//				tempA += comb(18, prime[i]) * Math.pow(a, prime[i]) * Math.pow(1 - a, 18 - prime[i]);
//				tempB += comb(18, prime[i]) * Math.pow(b, prime[i]) * Math.pow(1 - b, 18 - prime[i]);
			}
			double result = tempA + tempB - tempA * tempB;
			System.out.printf("%.6f\n", result);

		}
	}

	static double comb(int n, int r) {
		if (r == 0 || r == n)
			return 1.0;
		else
			return comb(n - 1, r - 1) + comb(n - 1, r);
	}
}
