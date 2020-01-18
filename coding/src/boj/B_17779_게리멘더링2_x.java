

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17779_게리멘더링2_x {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int x = 0; x < N - 2; x++) {
			for(int y = 1; y < N - 1; y++) {
				for(int d1 = 1; d1 <= x + 1; d1++) {
					for(int d2 = 1; d2 < N - 1; d2++) {
						
					}
				}
			}
		}
	}

}
