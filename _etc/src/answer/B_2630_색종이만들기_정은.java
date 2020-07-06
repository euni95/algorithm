package answer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2630_색종이만들기_정은 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int a = 1; a <= T; a++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 사람수

			long arr[] = new long[N];
			long max = Long.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				if (max < arr[i])
					max = arr[i];
			}
			Arrays.sort(arr);

			long end = max * M, people = 0, middle = 0, result = Long.MAX_VALUE;
			long start = 0;
			while (start <= end) {

				people = 0;
				middle = (start + end) / 2;
				for (int i = 0; i < N; i++) {
					people += middle / arr[i];
				}

				if (people >= M) {
					if (result > middle)
						result = middle;
					end = middle - 1;
				} else {
					start = middle + 1;
				}

			}
			System.out.println("#" + a + " " + result);

		}
	}

}