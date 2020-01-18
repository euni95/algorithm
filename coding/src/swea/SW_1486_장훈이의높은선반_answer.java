package A_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1486. 장훈이의 높은 선반

public class SW_1486_장훈이의높은선반_answer {
	static int result = 0;
	static int N, B;
	static int[] datas = null;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(reader.readLine());
		StringTokenizer st  = null;
		for(int t = 1; t <= TC ; t++) {
			st = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE; //최소값 구하기 초기화
			datas = new int[N];
			st = new StringTokenizer(reader.readLine());
			for(int i = 0 ; i < N; i++) {
				datas[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0);
			System.out.println("#"+t + " " + result);
		}

	}
	static void dfs(int sum , int depth) {
		if(depth >= N) {
			if(sum >= B) {
				if(result > sum - B) {
					result = sum - B;
				}
			}
			return;
		}
//		선택함, 선택안함
		dfs(sum + datas[depth], depth + 1);
		dfs(sum , depth + 1);
	}
	

}
