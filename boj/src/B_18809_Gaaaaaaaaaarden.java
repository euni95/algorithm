import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_18809_Gaaaaaaaaaarden {
	static int N, M, G, R, listSize, total, MAX;
	static int[][] garden;
	static boolean[] spot;
	static int[] color;
	static ArrayList<Point> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		garden = new int[N][M];
		list = new ArrayList<>();
		// 0: 호수, 1: 배양액 X, 2: 배양액 O
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
				if(garden[i][j] == 2) list.add(new Point(i, j));
			}
		}

		listSize = list.size();
		total = G + R;
		
		con : for(int i = 0; i < (1 << listSize); i++) {
			spot = new boolean[listSize];
			int cnt = 0;
			for(int j = 0; j < listSize; j++) {
				if((i & (1 << j)) > 0) {
					spot[j] = true;
					cnt++;
				}
				if(total < cnt) continue con;
			}
			if(cnt != total) continue;
			makeColor();
		}
		System.out.println(MAX);
		
	}
	
	private static void makeColor() {
		con : for(int i = 0; i < (1 << total); i++) {
			color = new int[total];
			int cnt = 0;
			for(int j = 0; j < total; j++) {
				if((i & (1 << j)) > 0) {
					color[j] = 0;
					cnt++;
				} else color[j] = 1;
				
				if(G < cnt) continue con;
			}
			if(cnt != G) continue;
			bfs();
		}
	}
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int[][][] visited;
	private static void bfs() {
		int cnt = 0;
		Queue<Point> q = new LinkedList<>();
		visited = new int[N][M][2];
		
		for(int i = 0; i < listSize; i++) {
			if(!spot[i]) continue;
			Point temp = list.get(i);
			q.add(new Point(temp, color[cnt]));
			visited[temp.x][temp.y][color[cnt]] = 1;
			cnt++;
		}
		
		int time = 1;
		int flower = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			time++;
			for(int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				if(visited[temp.x][temp.y][0] == -1) continue;
				
				for(int j = 0; j < 4; j++) {
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];
					
					if(tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
					if(garden[tx][ty] == 0 || visited[tx][ty][temp.color] != 0) continue;
					
					int checkColor = (temp.color - 1) * -1;
					if(visited[tx][ty][checkColor] == time) {
						flower++;
						visited[tx][ty][0] = -1;
						visited[tx][ty][1] = -1;
						continue;
					}
					if(visited[tx][ty][0] != 0 || visited[tx][ty][1] != 0) continue;
					visited[tx][ty][temp.color] = time;
					q.add(new Point(tx, ty, temp.color));
				}
			}
		}
		MAX = Math.max(flower, MAX);
	}
	
	static class Point {
		int x, y, color;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
		
		public Point(Point p, int color) {
			this.x = p.x;
			this.y = p.y;
			this.color = color;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", color=" + color + "]";
		}

		
	}
}
