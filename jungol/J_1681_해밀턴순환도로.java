import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J_1681_해밀턴순환도로 {
	static int N;
	static int[][] area;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		area = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		visited[0] = true;
		delivery(0, 0, 0);
		if(min != Integer.MAX_VALUE) System.out.println(min);
		else System.out.println(0);
	}
	
	static boolean[] visited;
	static boolean check;
	static int min = Integer.MAX_VALUE;
	private static void delivery(int start, int cost, int length) {
		if(cost > min) return;
		if(length == N - 1) {
			int result = cost + area[start][0];
			if(min > result && area[start][0] != 0) {
				min = result;
			}
			return;
		}
		for(int i = 1; i < N; i++) {
			if(!visited[i] && area[start][i] != 0) {
				visited[i] = true;
				delivery(i, cost + area[start][i], length + 1);
				visited[i] = false;
			}
		}
	}

}
