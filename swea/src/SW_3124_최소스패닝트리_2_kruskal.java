import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SW_3124_최소스패닝트리_2_kruskal {
	static int[] parent;
	static long weight;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()) + 1; // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수
			
			parent = new int[V];
			weight = 0; cnt = 0;
			
			for(int i = 0; i < V; i++) {
				parent[i] = i;
			}
			
			TreeSet<Point> tree = new TreeSet<>();
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken()); // 가중치
				
				tree.add(new Point(x, y, weight));
			}
			
			
			for(Point p : tree) {
				unionSet(p);
				if(cnt == V) break;
			}
			System.out.println("#" + t + " " + weight);
		}
	}

	private static void unionSet(Point p) {
		int x = findSet(p.x);
		int y = findSet(p.y);
		
		if(x != y) {
			parent[x] = y;
			weight += p.weight;
			cnt++;
		}
	}
	
	private static int findSet(int x) {
		if(x == parent[x]) return x;
		else {
			return parent[x] = findSet(parent[x]);
		}
	}

	static class Point implements Comparable<Point> {
		int x, y, weight;

		public Point(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return o.weight < this.weight ? 1 : -1;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}
		
	}

}
