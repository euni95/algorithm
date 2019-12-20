

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13458_시험감독 { // 시험 감독

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long result = 0;
		int A, B, C;
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st1.nextToken());
		C = Integer.parseInt(st1.nextToken());
		for (int i = 0; i < N; i++) {
			A = Integer.parseInt(st.nextToken());
			result++;
			if (A < B) continue;
			result += (A - B) / C;
			if ((A - B) % C != 0)
				result++;
		}
		System.out.println(result);
	}

}
