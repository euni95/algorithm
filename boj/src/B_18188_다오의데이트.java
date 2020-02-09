import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_18188_다오의데이트 {
	static int H, W, N, sx, sy;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		for(int i = 0; i < H; i++) {
			String temp = br.readLine();
			for(int j = 0; j < W; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j] == 'D') {
					sx = i; sy = j;
				}
			}
		}
		int n = Integer.parseInt(br.readLine());
		int[] disturb = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				switch (st.nextToken()) {
				case "W":
					disturb[i] |= 1;
					break;
					
				case "A":
					disturb[i] |= 2;
					break;
					
				case "S":
					disturb[i] |= 4;
					break;
					
				case "D":
					disturb[i] |= 8;
					break;
				}
			}
		}

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sx, sy, ""));
		int cnt = 0;
		boolean check = false;
		exit : while(!q.isEmpty()) {
			if(cnt == n) break;
			
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				Point temp = q.poll();
				
				for(int j = 0; j < 4; j++) {
					if((disturb[cnt] & (1 << j)) == 0) continue;
					
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];
					
					if(tx < 0 || ty < 0 || tx >= H || ty >= W) continue;
					if(map[tx][ty] == '@') continue;
					
					String t_path = temp.path;
					if(j == 0) t_path += "W";
					else if(j == 1) t_path += "A";
					else if(j == 2) t_path += "S";
					else if(j == 3) t_path += "D";
					
					if(map[tx][ty] == 'Z') {
						check = true;
						System.out.println("YES\n" + t_path);
						break exit;
					}
					
					q.add(new Point(tx, ty, t_path));
				}
			}
			cnt++;
		}
		if(!check) System.out.println("NO");
	}

	static class Point {
		int x, y;
		String path;

		public Point(int x, int y, String path) {
			this.x = x;
			this.y = y;
			this.path = path;
		}

	}
}
