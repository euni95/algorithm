import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_3282_knapsack {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 가방 개수
			int K = Integer.parseInt(st.nextToken()); // 최대 부피
			
			int[][] bag = new int[N][2]; // { V, C } _ 부피, 가치
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int V = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				bag[i][0] = V;
				bag[i][1] = C;
			}
			
			int[][] weight = new int[N + 1][K + 1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= K; j++) {
					if(j < bag[i - 1][0]) {
						weight[i][j] = weight[i - 1][j];
						continue;
					}
					weight[i][j] = Math.max(weight[i - 1][j - bag[i - 1][0]] + bag[i - 1][1], weight[i - 1][j]);					
				}
			}
			System.out.println("#" + t + " " + weight[N][K]);
		}
	}

}
