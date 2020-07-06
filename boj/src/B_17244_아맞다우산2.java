import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17244_아맞다우산2 {
	static Point start;
	static int N, M, bit;
	static char[][] home;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 세로
		home = new char[M][N];
		bit = 0;
		for(int i = 0; i < M; i++) {
			String input = br.readLine();
			for(int j = 0; j < N; j++) {
				char temp = input.charAt(j);
				home[i][j] = temp;
				if(temp == 'S') start = new Point(i, j, 0, 0);
				else if(temp == 'X') home[i][j] = (char) (bit++ + '0');
			}
		}
		bit = (1 << bit) - 1;
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		int visited[][][] = new int[M][N][bit + 1];
		exit : while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				for(int j = 0; j < 4; j++) {
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];
					
					if(tx < 0 || ty < 0 || tx >= M || ty >= N || home[tx][ty] == '#') continue;
					if(temp.check == bit && home[tx][ty] == 'E') {
						//끝
						System.out.println(temp.cnt + 1);
						break exit;
					}
					
					int check = temp.check;
					if(home[tx][ty] >= 48 && home[tx][ty] <= 57) {
						int now = home[tx][ty] - '0';
						if((check & (1 << now)) == 0) {
							check = check | (1 << now);
						}
					}
					
					if(visited[tx][ty][check] !=0 && visited[tx][ty][check] <= temp.cnt + 1) continue;
					visited[tx][ty][check] = temp.cnt + 1;
					q.add(new Point(tx, ty, check, temp.cnt + 1));
				}
			}
		}
	}

	public static class Point {
		int x, y, check, cnt;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int check, int cnt) {
			this.x = x;
			this.y = y;
			this.check = check;
			this.cnt = cnt;
		}

	}
}
