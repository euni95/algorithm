package A_4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16973_직사각형탈출 {
	static int N, M;
	static int[][] sq;
	static int H, W, sr, sc, fr, fc;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sq = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				sq[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		sr = Integer.parseInt(st.nextToken()); // 가장 왼쪽 위칸 x
		sc = Integer.parseInt(st.nextToken()); // 가장 왼쪽 위칸 y
		fr = Integer.parseInt(st.nextToken()); // 이동시킬 x
		fc = Integer.parseInt(st.nextToken()); // 이동시킬 y

		cnt = 0;
		find();
	}
	
	static int cnt;
	private static void find() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		boolean[][] visited = new boolean[N + 1][M + 1];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr, sc));
		visited[sr][sc] = true;
		
		while (!q.isEmpty()) {
			int qSize = q.size();

			for (int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				
				for(int j = 0; j < 4; j++) {
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];
					
					if(tx <= 0 || ty <= 0 || tx > N || ty > M) {
						continue;
					}
					if(tx + H - 1 > N || ty + W - 1 > M) {
						continue;
					}
					if(visited[tx][ty]) {
						continue;
					}
					
					boolean check = true;
					
					for(int x = tx; x < tx + H; x++) {
						if(sq[x][ty] == 1) check = false;
						if(sq[x][ty + W - 1] == 1) check = false;
					}
					for(int y = ty; y < ty + W; y++) {
						if(sq[tx][y] == 1) check = false;
						if(sq[tx + H - 1][y] == 1) check = false;
					}
					
					if(!check) {
						continue;
					}
 					if(tx == fr && ty == fc) {
 						System.out.println(++cnt);
 						return;
 					}
 					visited[tx][ty] = true;
					q.add(new Point(tx, ty));
				}
			}
			cnt++;
		}
		System.out.println(-1);
	}

}
