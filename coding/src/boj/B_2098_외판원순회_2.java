import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2098_외판원순회_2 {
	static int N;
	static int[][] city;
	static final int START = 0;
	static final int MAX = Integer.MAX_VALUE / 2;
	static int[][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		city = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		memo = new int[N][1 << N];
		System.out.println(tsp(START, 1 << START));
	}

	static int tsp(int idx, int v) {
		if(memo[idx][v] != 0) return memo[idx][v];
		if (v == ((1 << N) - 1)) {
			if(city[idx][START] != 0) return memo[idx][v] = city[idx][START];
			else return MAX;
		}
		int min = MAX;
		for (int i = 0; i < N; i++) {
			if((v & (1 << i)) != 0 || city[idx][i] == 0) continue;
			int temp = city[idx][i] + tsp(i, v | (1 << i));
			min = Math.min(min, temp);
		}
		return memo[idx][v] = min;
	}

}
