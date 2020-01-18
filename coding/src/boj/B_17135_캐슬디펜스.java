<<<<<<< HEAD
=======

>>>>>>> 2ffe1038461cc3d287407c5ac7fa70602a5404c3
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17135_캐슬디펜스 {
	static int N, M, D, eNum;
	static int[][] map;
	static ArrayList<Point> enemys;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		enemys = new ArrayList<>();
		eNum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					enemys.add(new Point(i, j));
					eNum++;
				}
			}
		}

		int size = 1 << M;
		int max = Integer.MIN_VALUE;
		for (int i = 7; i < size; i++) {
			boolean[] position = new boolean[M];
			int cnt = 0;
			for (int j = 0; j < M; j++) {
				if ((i & (1 << j)) > 0) {
					position[j] = true;
					cnt++;
				}
			}
			if (cnt == 3) {
				map_temp = new int[N][M];
<<<<<<< HEAD
				for (int j = 0; j < N; j++)
					System.arraycopy(map[j], 0, map_temp[j], 0, M);
=======
				for (int j = 0; j < N; j++) System.arraycopy(map[j], 0, map_temp[j], 0, M);
>>>>>>> 2ffe1038461cc3d287407c5ac7fa70602a5404c3
				max = Math.max(max, attack(position, N));
			}
		}
		System.out.println(max);
	}

	static int[][] map_temp;
	static int[] dx = {0, -1, 0};
	static int[] dy = {-1, 0, 1};
	
	static int attack(boolean[] ar, int limit) {
		int eNum_temp = eNum;
		int result = 0;
		
		while (eNum_temp > 0 && limit > 0) {
			ArrayList<Point> death = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				if (!ar[i]) continue;
				
				Queue<Point> q = new LinkedList<>();
				q.add(new Point(limit, i));
<<<<<<< HEAD
=======

>>>>>>> 2ffe1038461cc3d287407c5ac7fa70602a5404c3
				Point temp = null;
				int cnt = 0;
				aa : while(!q.isEmpty() && cnt != D) {
					int qSize = q.size();
					for(int j = 0; j < qSize; j++) {
						Point t = q.poll();
						for(int k = 0; k < 3; k++) {
							int tx = t.x + dx[k];
							int ty = t.y + dy[k];
							
							if(tx < 0 || ty < 0 || tx >= limit || ty >= M) continue;
							if(map_temp[tx][ty] == 1) {
								temp = new Point(tx, ty);
								break aa;
							}
<<<<<<< HEAD
							q.add(new Point(tx, ty));
=======
 							q.add(new Point(tx, ty));
>>>>>>> 2ffe1038461cc3d287407c5ac7fa70602a5404c3
						}
					}
					cnt++;
 				}
				if (temp != null) death.add(temp);
			}
			for (Point d : death) {
				if (map_temp[d.x][d.y] == 1) {
					map_temp[d.x][d.y] = 0;
					eNum_temp--;
					result++;
				}
			}
			limit--;
		}
		return result;
	}

	static int getDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
