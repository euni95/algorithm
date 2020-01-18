import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B_16234_인구이동 {
	static int N, L, R;
	static int[][] nation;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		nation = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				nation[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		int result = 0;
		while(true) {
			int temp = 0;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						temp += move(i, j);
					}
				}
			}
			if(temp == 0) break;
			result++;
		}
		System.out.println(result);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static int move(int x, int y) {
		Queue<Point> join = new LinkedList<>();
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		int pop = 0;
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			join.add(temp);
			pop += nation[temp.x][temp.y];
			
			for(int i = 0; i < 4; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];
				
				if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
				if(visited[tx][ty]) continue;
				
				int sub = Math.abs(nation[tx][ty] - nation[temp.x][temp.y]);
				if(sub >= L && sub <= R) {
					visited[tx][ty] = true;
					q.add(new Point(tx, ty));
				}
			}
		}
		if(join.size() == 1) return 0;
		
		pop = pop / join.size();
		while(!join.isEmpty()) {
			Point temp = join.poll();
			nation[temp.x][temp.y] = pop;
		}
		return 1;
	}

}
