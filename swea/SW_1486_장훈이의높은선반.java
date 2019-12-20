package A_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1486_장훈이의높은선반 {
	static int N, B;
	static int[] height;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			height = new int[N];
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
				max += height[i];
			}
			min = max;
			calc(0, 0);
			System.out.println("#" + t + " " + (min - B));
		}
	}
	
	static int min;
	static void calc(int depth, int sum) {
		if(depth == N) {
			if(sum >= B && min > sum) min = sum;
			return;
		}
			calc(depth + 1, sum + height[depth]);
			calc(depth + 1, sum);
	}

}
