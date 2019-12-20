import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15683_감시 {
	static int N, M, total;
	static int[][] room;
	static ArrayList<Point> cctv;
	static int[][] d = { 
			{ 0, 0, 0, 0 }, 
			{ 1, 0, 0, 0 }, 
			{ 1, 0, 1, 0 }, 
			{ 1, 1, 0, 0 }, 
			{ 1, 1, 1, 0 },
			{ 1, 1, 1, 1 } 
		};
	static int[] c_dir;

	public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      room = new int[N][M];
      cctv = new ArrayList<>();
      
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            room[i][j] = Integer.parseInt(st.nextToken());
            if(room[i][j] > 0 && room[i][j] < 6) cctv.add(new Point(i, j, room[i][j]));
            if(room[i][j] == 0) total++;
         }
      }
      c_dir = new int[cctv.size()];
      min = Integer.MAX_VALUE;
      calc(0);
      System.out.println(min);
	}
	
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static void calc(int idx) {
		if (idx == cctv.size()) {
			counting();
			return;
		}
		for (int i = 0; i < 4; i++) {
			Point temp = cctv.get(idx);
			if (room[temp.x][temp.y] == 2 && i >= 2) continue;
			if (room[temp.x][temp.y] == 5 && i != 0) continue;
<<<<<<< HEAD
=======

>>>>>>> 2ffe1038461cc3d287407c5ac7fa70602a5404c3
			c_dir[idx] = i;
			calc(idx + 1);
		}
	}
	
	static int min;
	private static void counting() {
		int cnt = 0;
		boolean[][] visited = new boolean[N][M];
<<<<<<< HEAD
		for (int i = 0; i < cctv.size(); i++) {
			for (int j = 0; j < 4; j++) {
				if(d[cctv.get(i).scope][(j + c_dir[i]) % 4] == 0) continue;
				int tx = cctv.get(i).x;
				int ty = cctv.get(i).y;
				while(true) {
					tx += dx[j];
					ty += dy[j];
=======

		for (int i = 0; i < cctv.size(); i++) {
			for (int j = 0; j < 4; j++) {
				if(d[cctv.get(i).scope][(j + c_dir[i]) % 4] == 0) continue;
				
				int tx = cctv.get(i).x;
				int ty = cctv.get(i).y;
				
				while(true) {
					tx += dx[j];
					ty += dy[j];
					
>>>>>>> 2ffe1038461cc3d287407c5ac7fa70602a5404c3
					if(tx < 0 || ty < 0 || tx >= N || ty >= M || room[tx][ty] == 6) break;
					if(visited[tx][ty]) continue;
					visited[tx][ty] = true;
					if(room[tx][ty] == 0) cnt++;
				}
			}
		}
		min = Integer.min(min, total - cnt);
	}

	static class Point {
		int x, y, scope;

		public Point(int x, int y, int scope) {
			this.x = x;
			this.y = y;
			this.scope = scope;
		}

	}
}
