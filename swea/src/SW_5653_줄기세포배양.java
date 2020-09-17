import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5653_줄기세포배양 {
	static int N, M, K;
	static int[][][] grid;
	static Queue<Point> q, yet;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			grid = new int[N + K][M + K][2];
			
			q = new LinkedList<>();
			
			for(int i = K / 2; i < (K / 2) + N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = K / 2; j < (K / 2) + M; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp != 0) {
						grid[i][j][0] = -1;
						grid[i][j][1] = temp;
						q.add(new Point(i, j, temp, temp));
					}
				}
			}
			
			yet = new LinkedList<>();
			int cnt = 1;
			while(!q.isEmpty()) {
				if(cnt == K + 1) break;
				int qSize = q.size();
				
				for(int i = 0; i < qSize; i++) {
					Point temp = q.poll();
					
					
					if(temp.activeCnt == 0) {
						for(int j = 0; j < 4; j++) {
							int tx = temp.x + dx[j];
							int ty = temp.y + dy[j];
							
							if(grid[tx][ty][0] == 0 || (grid[tx][ty][0] == cnt && grid[tx][ty][1] < temp.deathCnt)) {
								grid[tx][ty][0] = cnt;
								grid[tx][ty][1] = temp.deathCnt;
								q.add(new Point(tx, ty, temp.deathCnt, temp.deathCnt));
							} 
						}
						yet.add(temp);
						
					} else {
						q.add(new Point(temp.x, temp.y, temp.activeCnt - 1, temp.deathCnt));
					}
				}
				
				qSize = q.size();
				for(int i = 0; i < qSize; i++) {
					Point temp = q.poll();
					if(grid[temp.x][temp.y][1] != temp.deathCnt) continue;
					q.add(temp);
				}
				
				if(!yet.isEmpty()) {
					int ySize = yet.size();
					for(int i = 0; i < ySize; i++) {
						Point temp = yet.poll();
												
						temp.deathCnt -= 1;
						if(temp.deathCnt == 0) continue;
						yet.add(temp);
					}
				}
				cnt++;
			}
			sb.append("#").append(t).append(" ").append(q.size() + yet.size()).append("\n");
		}
		
		System.out.println(sb);
	}
	static class Point {
		int x, y, activeCnt, deathCnt;

		public Point(int x, int y, int activeCnt, int deathCnt) {
			this.x = x;
			this.y = y;
			this.activeCnt = activeCnt;
			this.deathCnt = deathCnt;
		}

	}
}
