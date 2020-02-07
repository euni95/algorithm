import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14888_연산자끼워넣기_2 {
	static int N, MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;
	static int[] num, op;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(st.nextToken());

		go(1, num[0]);
		System.out.println(MAX);
		System.out.println(MIN);
	}

	private static void go(int idx, int current) {
		if (idx == N) {
			MAX = Integer.max(MAX, current);
			MIN = Integer.min(MIN, current);
			return;
		}
		if (op[0] > 0) {
			op[0]--;
			go(idx + 1, current + num[idx]);
			op[0]++;
		}
		if (op[1] > 0) {
			op[1]--;
			go(idx + 1, current - num[idx]);
			op[1]++;
		}
		if (op[2] > 0) {
			op[2]--;
			go(idx + 1, current * num[idx]);
			op[2]++;
		}
		if (op[3] > 0) {
			op[3]--;
			go(idx + 1, current / num[idx]);
			op[3]++;
		}
	}
}
