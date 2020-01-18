import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2468_안전영역 {
	static int N;
	static int[][] area;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		int maxHeight = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(maxHeight < area[i][j]) maxHeight = area[i][j];
			}
		}
		boolean[][] visited;
		int cnt = 0;
		int max = 0;
		for(int i = 0; i <= maxHeight; i++) {
			visited = new boolean[N][N];
			cnt = 0;
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(area[j][k] > i && !visited[j][k]) {
						visited[j][k] = true;
						dfs(j, k, i, visited);
						cnt++;
					}
				}
			}
			if(max < cnt) max = cnt;
		}
		System.out.println(max);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static void dfs(int x, int y, int height, boolean[][] visited) {
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
			if(area[tx][ty] <= height || visited[tx][ty]) continue;
			visited[tx][ty] = true;
			dfs(tx, ty, height, visited);
		}
	}
}
