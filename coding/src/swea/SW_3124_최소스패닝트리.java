import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SW_3124_최소스패닝트리 { // Kruscal's algorithm
	static int[] parent; // 간선의 개수 X, 정점의 개수만큼 만듦
	static long result;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			result = 0; cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			parent = new int[V + 1];
			makeSet();

			TreeSet<Edge> tree = new TreeSet<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				tree.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}

			for (Edge e : tree) {
				unionSet(e);

				if (cnt == V) break; // 가지치기
			}

			System.out.println("#" + t + " " + result);
		}
	}

	static int findSet(int x) {
		if (parent[x] == x)
			return x;
		else {
			return parent[x] = findSet(parent[x]);
		}
	}

	static void unionSet(Edge e) {
		int x = findSet(e.x);
		int y = findSet(e.y);

		if (x != y) {
			parent[y] = x;
			result += e.weight;
			cnt++;
			System.out.println(e.x + " " + e.y);
			System.out.println(x + " " + y);
			System.out.println(Arrays.toString(parent));
		}
	}

	static void makeSet() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int weight;

		public Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight > o.weight ? 1 : -1;
		}

	}
}
