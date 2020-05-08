import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14499_주사위굴리기 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0}, dice = {0, 0, 0, 0, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			x += dx[dir-1];
			y += dy[dir-1];
			
			if(x < 0 || y < 0 || x >= N || y >= M) {
				x -= dx[dir-1];
				y -= dy[dir-1];
				continue;
			}
			
			if(dir == 1) { // 동
				int temp = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[4];
				dice[4] = temp;
			}
			
			else if(dir == 2) { // 서
				int temp = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[3];
				dice[3] = temp;
			}
			
			else if(dir == 3) { // 북
				int temp = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = temp;
			}
			
			else if(dir == 4) { // 남
				int temp = dice[3];
				dice[3] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[0];
				dice[0] = temp;
			}
			
			if(map[x][y] == 0) {
				map[x][y] = dice[3];
			} else {
				dice[3] = map[x][y];
				map[x][y] = 0;
			}
			
			sb.append(dice[1]).append("\n");
		}
		System.out.println(sb);
	}
}
