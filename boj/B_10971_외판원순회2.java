import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10971_외판원순회2 {
	static int N;
	static int[][] city;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		city = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			visited[i] = true;
			dfs(i, i, visited, 0, 0);
		}
		System.out.println(min);
	}
	
	static int min = Integer.MAX_VALUE;
	private static void dfs(int start, int idx, boolean[] visited, int depth, int sum) {
		if(depth == N - 1) {
			if(city[idx][start] == 0) return;
			int result = sum + city[idx][start];
			if(min > result) min = result;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && city[idx][i] != 0) {
				visited[i] = true;
				dfs(start, i, visited, depth + 1, city[idx][i] + sum);
				visited[i] = false;
			}
		}
	}
	
}
