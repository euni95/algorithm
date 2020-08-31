import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17090_미로탈출하기 {
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static char[][] maze;
	static boolean[][] visited;
	static int N, M, answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			maze[i] = st.nextToken().toCharArray();
		}
		
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			if(maze[i][0] == 'L') escape(i, 0);
			if(maze[i][M - 1] == 'R') escape(i, M - 1);
		}

		for (int i = 0; i < M; i++) {
			if(maze[0][i] == 'U') escape(0, i);
			if(maze[N - 1][i] == 'D') escape(N - 1, i);
		}
		
		System.out.println(answer);
	}

	private static void escape(int x, int y) {
		if(visited[x][y]) return;
		visited[x][y] = true;
		answer++;
		
		if (x > 0 && maze[x - 1][y] == 'D') escape(x - 1, y);
		if (y < M - 1 && maze[x][y + 1] == 'L') escape(x, y + 1);
		if (x < N - 1 && maze[x + 1][y] == 'U') escape(x + 1, y);
		if (y > 0 && maze[x][y - 1] == 'R') escape(x, y - 1);
	}
}
