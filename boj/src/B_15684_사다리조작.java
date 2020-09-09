import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15684_사다리조작 {
	static int N, M, H;
	static boolean[][] ladder;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로선 개수
		M= Integer.parseInt(st.nextToken()); // 가로선 개수
		H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치의 개수
		
		if(N == 0 || M == 0) {
			System.out.println(0);
			return;
		}
		
		ladder = new boolean[H + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); 
			ladder[a][b] = true;
		}
		for(int i = 0; i <= 3; i++) comb(1, 1, 0, i);
		System.out.println(-1);
	}
	private static void comb(int x, int y, int cnt, int max) {
		if(max == cnt) {
			if(checkLadder()) {
				System.out.println(cnt);
				System.exit(0);
			} else return;
		}
		for(int i = x; i <= H; i++) {
			for(int j = y; j < N; j++) {
				if(ladder[i][j]) {
					j++;
					continue;
				}
				if(ladder[i][j + 1]) {
					j += 2;
					continue;
				}
				
				ladder[i][j] = true;
				comb(i, j + 2, cnt + 1, max);
				ladder[i][j] = false;
			}
			y = 1;
		}

	}

	private static boolean checkLadder() {
		for(int i = 1; i <= N; i++) {
			int x = 1, y = i;
			while(x <= H) {
				if(ladder[x][y - 1]) y -= 1;
				else if(ladder[x][y]) y += 1;
				x += 1;
			}
			if(i != y) return false;
		}
		return true;
	}
}