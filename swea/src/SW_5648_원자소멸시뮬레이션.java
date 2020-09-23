import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5648_원자소멸시뮬레이션 {
	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, -1, 1};
	static int N, K, minX, minY, maxX, maxY, sum;
	static int[][] map = new int[4001][4001];
	static Queue<Atom> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			minX = 4000; minY = 4000; maxX = -4000; maxY = -4000; 
			sum = 0;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int dir = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				q.add(new Atom(x, y, dir, k));
				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
				map[x][y] = k;
			}
			removeAtom();
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void removeAtom() {
		while (!q.isEmpty()) {
			Atom temp = q.poll();
			
			if (map[temp.x][temp.y] != temp.k) {
				sum += map[temp.x][temp.y];
				map[temp.x][temp.y] = 0;
				continue;
			}
			map[temp.x][temp.y] = 0;

			int tx = temp.x + dx[temp.dir];
			int ty = temp.y + dy[temp.dir];

			if (tx > maxX || tx < minX || ty > maxY || ty < minY) continue;

			if (map[tx][ty] == 0) {
				map[tx][ty] = temp.k;
				q.add(new Atom(tx, ty, temp.dir, temp.k));
			} else map[tx][ty] += temp.k;
		}
	}

	static class Atom {
		int x, y, dir, k;

		public Atom(int x, int y, int dir, int k) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Atom [x=" + x + ", y=" + y + ", dir=" + dir + ", k=" + k + "]";
		}
		
		
	}
}
