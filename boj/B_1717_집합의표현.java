import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1717_집합의표현 {
	static int[] parent;
	static int n, m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// makeSet
		parent = new int[n + 1];
		for(int i = 1; i <= n; i++) parent[i] = i;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op == 0) {
				unionSet(a, b);
			} else {
				a = findSet(a);
				b = findSet(b);
				
				if(a == b) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void unionSet(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a != b) {
			parent[a] = b;
		}
	}

	private static int findSet(int a) {
		if(parent[a] == a) return a;
		else {
			int temp = findSet(parent[a]);
			parent[a] = temp;
			return temp;
		}
	}

}
