import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_3289_서로소집합 {
	static int n, m;
	static int[] parent;
	static int op, a, b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			
			//MakeSet
			for(int i = 1; i <= n; i++) parent[i] = i;
			for(int i = 0; i < m; i++) {
				st = new  StringTokenizer(br.readLine());
				op = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if(op == 0) { // 합집합
					unionSet(a, b);
				} else { // 같은 집합에 포함되어 있는지 확인하는 연산
					if(findSet(a) == findSet(b)) sb.append("1");
					else sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x != y) {
			parent[x] = y;
		}
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
