import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20057_마법사상어와토네이도 {
	static int N, x, y, dir, idx, outSand;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static int[][] sand;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sand = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				sand[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		x = y = N / 2;
		idx = 1;
		tornado();
		System.out.println(outSand);
	}

	private static void tornado() {
		if(idx >= N) {
			idx -= 1;
			moveTornado();
			return;
		}
		
		moveTornado();
		if(dir == 1 || dir == 3) ++idx;
		dir = (dir + 1) % 4;
		tornado();
	}

	private static void moveTornado() {
		for(int i = 0; i < idx; i++) {
			moveSand();
			x += dx[dir];
			y += dy[dir];
		}
	}
	
	static int[][][] scatter = {
			{
				{1, 0}, {-1, 0}, {2, -1}, {1, -1}, {-1, -1}, {-2, -1},
				{1, -2}, {-1, -2}, {0, -3}
			},
			{
				{0, -1}, {0, 1}, {1, -2}, {1, -1}, {1, 1}, {1, 2},
				{2, -1}, {2, 1}, {3, 0}
			},
			{
				{-1, 0}, {1, 0}, {-2, 1}, {-1, 1}, {1, 1}, {2, 1},
				{-1, 2}, {1, 2}, {0, 3}
			},
			{
				{0, -1}, {0, 1}, {-1, -2}, {-1, -1}, {-1, 1}, {-1, 2},
				{-2, -1}, {-2, 1}, {-3, 0}
			}
	};

	static double[] sCost = { 0.01, 0.01, 0.02, 0.07, 0.07, 0.02, 0.1, 0.1, 0.05 };
	
	private static void moveSand() {
		int originalSand = sand[x + dx[dir]][y + dy[dir]];
		if(originalSand == 0) return;

		int rest = originalSand;
		
		int tx = 0, ty = 0;
		for(int i = 0; i < 9; i++) {
			tx = x + scatter[dir][i][0];
			ty = y + scatter[dir][i][1];
			
			int scatteredSand = (int) (originalSand * sCost[i]);
			if(tx < 0 || ty < 0 || tx >= N || ty >= N) outSand += scatteredSand;
			else sand[tx][ty] += scatteredSand;
			
			rest -= scatteredSand;
		}
		
		tx = x + dx[dir] * 2; ty = y + dy[dir] * 2;
		if(tx < 0 || ty < 0 || tx >= N || ty >= N) outSand += rest;
		else sand[tx][ty] += rest; 
	}
	
}
