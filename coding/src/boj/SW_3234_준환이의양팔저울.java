import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_3234_준환이의양팔저울 {
	static int N;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] weight = new int[N];
			visited = new int[1 << N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) weight[i] = Integer.parseInt(st.nextToken());
			cnt = 0;
			perm(weight, 0, 0, 0);
			System.out.println("#" + t + " " + cnt);
		}
	}
	static int cnt;
	static void perm(int[] weight, int left, int right, int idx) {
		if(left < right) return;
		if (idx == N) {
			cnt++;
			return;
		}
		for (int i = idx; i < N; i++) {
			swap(weight, idx, i);
			perm(weight, left + weight[idx], right, idx + 1);
			perm(weight, left, right + weight[idx], idx + 1);
			swap(weight, idx, i);
		}
	}

	static void swap(int[] weight, int x, int y) {
		int temp = weight[x];
		weight[x] = weight[y];
		weight[y] = temp;
	}
}
