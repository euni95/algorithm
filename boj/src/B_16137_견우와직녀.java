import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16137_견우와직녀 {
	static int N, M, min, max;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    static Queue<Point> q = new LinkedList<>();
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		max = M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(map[i][j], max);
			}
		}
		
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 && checkBridge(i, j)) {
					map[i][j] = M;
					go();
                    q.clear();
					map[i][j] = 0;
				}
			}
		}
		System.out.println(min);
	}

	private static void go() {
		boolean[][] v = new boolean[N][N];
		v[0][0] = true;
		q.add(new Point(0, 0));
		
		int time = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			if(time >= min) return;
			
			for(int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				
				for(int j = 0; j < 4; j++) {
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];
					
					if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
					if(v[tx][ty]) continue;
					if(tx == N - 1 && ty == N - 1) {
						min = Math.min(min, time);
						return;
					}
					int m = map[tx][ty];
					if(m == 0) continue;
					if(m == 1 || (map[temp.x][temp.y] == 1 && time % m == 0)) {
						v[tx][ty] = true;
						q.add(new Point(tx, ty));
					} else q.add(new Point(temp.x, temp.y));
				}
//				if(map[temp.x][temp.y] == 1) q.add(new Point(temp.x, temp.y));
			}
			time++;
		}
	}

	private static boolean checkBridge(int x, int y) {
		int check = 0, cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
			if(map[tx][ty] == 0) {
				cnt++;
				check |= 1 << i;
			}
		}
		if(cnt == 0 || cnt == 1 || check == 5 || check == 10) return true;
		else return false;
	}
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
