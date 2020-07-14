import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_19238_스타트택시 {
	static int N, M, fuel, sx, sy, psgIdx, min = -1;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1};
	static int[][] map, psg;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 활동 영역 NxN
		M = Integer.parseInt(st.nextToken()); // 승객 수
		fuel = Integer.parseInt(st.nextToken()); // 시작 연료
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) map[i][j] = -1;
			}
		}
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		psg = new int[M][2];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i + 1;
			psg[i][0] = Integer.parseInt(st.nextToken()) - 1;
			psg[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}
		for(int i = 0; i < M; i++) {
			if(getPsg() == -1) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(fuel);
	}
	
	private static int getPsg() {
		if(!calcStart()) return -1;
		if(fuel - min < 0) return -1;
		fuel -= min;
		map[sx][sy] = 0;
		min = -1;
		int dist = calcDist(psg[psgIdx][0], psg[psgIdx][1]);
		if(dist == -1 ||fuel - dist < 0) return -1;
		fuel += dist;
		sx = psg[psgIdx][0];
		sy = psg[psgIdx][1];
		return fuel;
	}

	private static boolean calcStart() {
		if(map[sx][sy] > 0) {
			psgIdx = map[sx][sy] - 1;
			map[sx][sy] = 0;
			min = 0;
			return true;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(sx);
		q.add(sy);
		int cnt = 0;
		boolean[][] v = new boolean[N][N];
		v[sx][sy] = true;
		while(!q.isEmpty()) {
			int qSize = q.size();
			cnt++;
			for(int i = 0; i < qSize/2; i++) {
				int qx = q.poll();
				int qy = q.poll();
				
				for(int j = 0; j < 4; j++) {
					int tx = qx + dx[j];
					int ty = qy + dy[j];
					
					if(tx < 0 || ty < 0 || tx >= N || ty >= N || map[tx][ty] == -1 || v[tx][ty]) continue;
					if(map[tx][ty] > 0) {
						boolean flag = true;
						if(min != -1) {
							if(sx < tx) flag = false;
							else if(sx == tx && sy < ty) flag = false;
						}
						if(flag) {
							min = cnt;
							psgIdx = map[tx][ty] - 1;
							sx = tx; sy = ty;
						}
					}
					v[tx][ty] = true;
					q.add(tx);
					q.add(ty);
				}
			}
			if(min != -1) return true;
		}
		return false;
	}

	private static int calcDist(int ax, int ay) {
		if(sx == ax && sy == ay) return 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(sx);
		q.add(sy);
		int cnt = 0;
		boolean[][] v = new boolean[N][N];
		v[sx][sy] = true;
		while(!q.isEmpty()) {
			int qSize = q.size();
			cnt++;
			for(int i = 0; i < qSize/2; i++) {
				int qx = q.poll();
				int qy = q.poll();
				
				for(int j = 0; j < 4; j++) {
					int tx = qx + dx[j];
					int ty = qy + dy[j];
					
					if(tx < 0 || ty < 0 || tx >= N || ty >= N || map[tx][ty] == -1 || v[tx][ty]) continue;
					if(tx == ax && ty == ay) return cnt;
					v[tx][ty] = true;
					q.add(tx);
					q.add(ty);
				}
			}
		}
		return -1;
	}
	
}
