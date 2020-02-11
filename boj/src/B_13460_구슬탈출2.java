import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_13460_구슬탈출2 {
	static int N, M, trX, trY, tbX, tbY;
	static char[][] board;
	static Point red, blue;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static boolean[][][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j] == 'R') red = new Point(i, j);
				else if(board[i][j] == 'B') blue = new Point(i, j);
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(red);
		q.add(blue);
		visited = new boolean[N][M][N][M];
		int cnt = 1;
		boolean check = false;
		exit : while(!q.isEmpty()) {
			int qSize = q.size();
			if(cnt == 11) break;
			
			for(int i = 0; i < qSize/2; i++) {
				Point tr = q.poll();
				Point tb = q.poll();
				
				for(int j = 0; j < 4; j++) {
					trX = tr.x; trY = tr.y;
					tbX = tb.x; tbY = tb.y;
					
					// 0: red 먼저, 1: blue 먼저
					int order = 0;
					if(j == 0 && trX > tbX) order = 1;
					else if(j == 1 && trX < tbX) order = 1;
					else if(j == 2 && trY > tbY) order = 1;
					else if(j == 3 && trY < tbY) order = 1;
					
					boolean r = false, b = false;
					
					if(order == 0) {
						r = move(j, 0);
						b = move(j, 1);
					} else {
						b = move(j, 1);
						r = move(j, 0);
					}
					
					if(b) continue;
					else if(!b && r) {
						check = true;
						break exit;
					}
					
					if(visited[trX][trY][tbX][tbY]) continue;
					visited[trX][trY][tbX][tbY] = true;
					q.add(new Point(trX, trY));
					q.add(new Point(tbX, tbY));
				}
			}
			cnt++;
		}
		if(check) System.out.println(cnt);
		else System.out.println(-1);
	}

	private static boolean move(int dir, int flag) {
		if(flag == 0) {
			while(true) {
				trX += dx[dir];
				trY += dy[dir];
				
				if(trX < 0 || trY < 0 || trX >= N || trY >= M || board[trX][trY] == '#' || (trX == tbX && trY == tbY)) {
					trX -= dx[dir];
					trY -= dy[dir];
					return false;
				}
				if(board[trX][trY] == 'O') {
					trX += dx[dir];
					trY += dy[dir];
					return true;
				}
			}
		} else {
			while(true) {
				tbX += dx[dir];
				tbY += dy[dir];
				
				if(tbX < 0 || tbY < 0 || tbX >= N || tbY >= M || board[tbX][tbY] == '#'|| (trX == tbX && trY == tbY)) {
					tbX -= dx[dir];
					tbY -= dy[dir];
					return false;
				}
				
				if(board[tbX][tbY] == 'O') {
					tbX += dx[dir];
					tbY += dy[dir];
					return true;
				}
			}
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
