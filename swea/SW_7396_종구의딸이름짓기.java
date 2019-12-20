import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_7396_종구의딸이름짓기 {
	static int N, M;
	static char[][] board;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new char[N][M];
			for(int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
			
			Queue<Point> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			q.add(new Point(0, 0));
			visited[0][0] = true;
			
			String result = "";
			char ch = board[0][0];
			while(!q.isEmpty()) {
				result += String.valueOf(ch);
				int qSize = q.size();
				char tempC = '{';
				
				for(int i = 0; i < qSize; i++) {
					Point temp = q.poll();
					
					if(ch != board[temp.x][temp.y]) continue;
					for(int j = 0; j < 2; j++) {
						int tx = temp.x + dx[j];
						int ty = temp.y + dy[j];
						
						if(tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
						if(visited[tx][ty]) continue;
						if(tempC > board[tx][ty]) tempC = board[tx][ty];
						q.add(new Point(tx, ty));
						visited[tx][ty] = true;
					}
				}
				ch = tempC;
			}
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
