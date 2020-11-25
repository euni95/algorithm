import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_20208_진우의민트초코우유 {
	static int N, M, H, homeX, homeY, max;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		int idx = 2;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 1) {
					map[i][j] = idx++;
				} else if (map[i][j] == 1) {
					homeX = i;
					homeY = j;
				}
			}
		}
		
		boolean[][][] visited = new boolean[N][N][1 << 10];
		visited[homeX][homeY][0] = true;
		Queue<Mint> q = new LinkedList<>();
		q.add(new Mint(homeX, homeY, M, 0, 0));
		
		while(!q.isEmpty()) {
			Mint temp = q.poll();
			if(temp.hp == 0) continue;
			temp.hp--;
			
			for(int i = 0; i < 4; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];
				
				if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
				if(tx == homeX && ty == homeY) {
					max = Integer.max(max, temp.cnt);
				}
				
				int tempV = temp.v;
				int tempHP = temp.hp;
				int tempCnt = temp.cnt;
				
				if(map[tx][ty] > 1 && (tempV & 1 << (map[tx][ty] - 2)) == 0) {
					tempV = tempV | (1 << (map[tx][ty] - 2));
					tempHP += H;
					tempCnt++;
				}
				
				if(visited[tx][ty][tempV]) continue;
				visited[tx][ty][tempV] = true;
				
				q.add(new Mint(tx, ty, tempHP, tempV, tempCnt));
			}
		}
		
		System.out.println(max);
	}

	static class Mint {
		int x, y, hp, v, cnt;

		public Mint(int x, int y, int hp, int v, int cnt) {
			this.x = x;
			this.y = y;
			this.hp = hp;
			this.v = v;
			this.cnt = cnt;
		}

	}
}
