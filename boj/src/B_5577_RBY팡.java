import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_5577_RBY팡 {
	static int N, min;
	static int[] balls;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		min = N;
		balls = new int[N];
		for(int i = 0; i < N; i++) balls[i] = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int temp = balls[i];
			for(int j = 1; j <= 3; j++) {
				if(temp == j) continue;
				pang(i - 1, i + 1, j);
			}
		}
		System.out.println(min);
	}

	private static void pang(int left, int right, int color) {
		int cnt = N, tempCnt = 1;
		while(true) {
			while(left >= 0) {
				if(balls[left] != color) break;
				tempCnt++;
				left--;
			}
			while(right < N) {
				if(balls[right] != color) break;
				tempCnt++;
				right++;
			}
			if(tempCnt < 4) break;
			cnt -= tempCnt;
			if(left < 0 || right >= N || balls[left] != balls[right]) break;
			color = balls[left];
			tempCnt = 0;
		}
		min = Math.min(min, cnt);
	}
}
