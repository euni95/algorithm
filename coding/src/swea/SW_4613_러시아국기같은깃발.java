

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4613_러시아국기같은깃발 {
	static int N, M;
	static char[][] flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			flag = new char[N][M];
			for(int i = 0; i < N; i++) flag[i] = br.readLine().toCharArray();

			min = Integer.MAX_VALUE;
			for(int i = 1; i < N - 1; i++) {
				for(int j = 1; j < N - i ; j++) {
					calc(i, j, N-i-j);
				}
			}
			System.out.println("#" + t + " " + min);
		}
	}
	
	static int min;
	private static void calc(int w, int b, int r) {
		b = w + b; r = w + b + r;
		int cnt = 0;
		
		//흰색
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < M; j++) {
				if(flag[i][j] != 'W') cnt++;
			}
		}
		//파란색
		for(int i = w; i < b; i++) {
			for(int j = 0; j < M; j++) {
				if(flag[i][j] != 'B') cnt++;
			}
		}
		//빨간색
		for(int i = b; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(flag[i][j] != 'R') cnt++;
			}
		}
		min = Math.min(min, cnt);
	}

}
