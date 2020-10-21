import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_20056_마법사상어와파이어볼 {
	static int N, M, K, x, y, m, s, d;
	static int[][] map;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 격자 크기
		M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
		K = Integer.parseInt(st.nextToken()); // 이동 횟수
		map = new int[N][N];
	
		Queue<Fireball> q = new LinkedList<>();
		PriorityQueue<Fireball> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			map[x][y]++;
			q.add(new Fireball(x, y, m, s, d));
		}
		int cnt = 0;
		while(!q.isEmpty() && cnt < K) {
			while(!q.isEmpty()) {
				Fireball temp = q.poll();
				map[temp.x][temp.y]--;
				
				int tx = temp.x + dx[temp.d] * temp.s;
				int ty = temp.y + dy[temp.d] * temp.s;

				if(tx < 0) {
					int re = tx % N;
					tx = re == 0 ? 0 : N + re;
				} else if(tx >= N) tx %= N;
				
				if(ty < 0) {
					int re = ty % N;
					ty = re == 0 ? 0 : N + re;
				} else if(ty >= N) ty %= N;
				
				temp.x = tx;
				temp.y = ty;
				
				map[tx][ty]++;
				pq.add(temp);
			}
			while(!pq.isEmpty()) {
				Fireball temp = pq.poll();
				
				if(map[temp.x][temp.y] >= 2) {
					x = temp.x;
					y = temp.y;
					m = temp.m;
					s = temp.s;
					
					int even = temp.d % 2 == 0 ? 1 : 0;
					for(int i = 0; i < map[x][y] - 1; i++) {
						Fireball fb = pq.poll();
						m += fb.m;
						s += fb.s;
						if(fb.d % 2 == 0) even++;
					}
					m /= 5;
					if(m != 0) {
						s /= map[x][y];
						int dir = 1;
						if(even == map[x][y] || even == 0) dir = 0;
						for(int i = 0; i < 4; i++) {
							q.add(new Fireball(x, y, m, s, dir));
							dir += 2;
						}
						map[x][y] = 4;
					} else map[x][y] = 0;
				} else {
					q.add(temp);
				}
			}
			cnt++;
		}
		int sum = 0;
		while(!q.isEmpty()) sum += q.poll().m;
		System.out.println(sum);
	}
	
	static class Fireball implements Comparable<Fireball>{
		int x, y, m, s, d;

		public Fireball(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public int compareTo(Fireball o) {
			if(this.x == o.x) return this.y < o.y ? -1 : 1;
			else return this.x < o.x ? -1 : 1;
		}
	}
}
