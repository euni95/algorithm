import java.util.Arrays;

import java.util.LinkedList;

import java.util.Queue;

import java.util.Scanner;



public class JO_1113_구급대_BFS_2차원배열 {
	static class Status{
		int r, c, cnt, dir;
		public Status(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int R, C, fr, fc, min = Integer.MAX_VALUE;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		fr = sc.nextInt();
		fc = sc.nextInt();
		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs();

		System.out.println(min-1);
	}
	static void bfs() {
		Queue<Status> queue = new LinkedList<>();
		int[][] visited = new int[R][C];
		for(int i = 0; i < R; i++)
			Arrays.fill(visited[i], Integer.MAX_VALUE);

		queue.add(new Status(0, 0, 0, 0));
		visited[0][0] = 0;
		while(!queue.isEmpty()){
			Status st = queue.poll();
			if( fr == st.r && fc == st.c ) {
				min = Math.min(st.cnt, min);
			}

			for(int d = 0; d < 4; d++) {
				int nr = st.r + dr[d];
				int nc = st.c + dc[d];
				if( nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				if(map[nr][nc] == 0) {
					continue;
				}
				if(visited[nr][nc] <= st.cnt) {
					continue;
				}
				int cnt = st.cnt;
				if(st.dir != d) {
					cnt++;
				}
				visited[nr][nc] = st.cnt;
				queue.add(new Status(nr, nc, cnt, d));
			}
		}
	}
}