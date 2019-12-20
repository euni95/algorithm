import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_7465_창용마을무리의개수 {
	static int N, M, a, b, cnt;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N+1];
			for(int i = 1; i <= N; i++) parent[i] = i;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				unionSet(a, b);
			}
			cnt = 0;
			for(int i = 1; i <= N; i++) if(parent[i] == i) cnt++;
			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb.toString());
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else {
			int temp = findSet(parent[x]);
			parent[x] = temp;
			return temp;
		}
	}
	static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x != y) parent[y] = x;
	}
}
