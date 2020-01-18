import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J_1863_종교 {
	static int n, m;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 0; i <= n; i++) parent[i] = i;
		for(int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			unionSet(i, j);
		}
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(parent[i] == i) cnt++;
		}
		System.out.println(cnt);
	}
	
	static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x != y) parent[y] = x;
	}

	static int findSet(int x) {
		if(parent[x] == x) return x;
		else {
			int temp = findSet(parent[x]);
			parent[x] = temp;
			return temp;
		}
	}
}
