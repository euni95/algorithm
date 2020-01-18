import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B_17472_다리만들기2 {
	static int N, M, cnt;
	static int[][] map;
	static int[] parent;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static TreeSet<Edge> tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					cnt++;
					map[i][j] = cnt;
					visited[i][j] = true;
					islandCounting(visited, i, j);
				}
			}
		}
		parent = new int[cnt];
		tree = new TreeSet<>();
		// findEdge
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					findEdge(i, j);
				}
			}
		}
		
		// makeSet
		for (int i = 0; i < cnt; i++) {
			parent[i] = i;
		}
		
		for(Edge e : tree) {
//			System.out.println(e);
			unionSet(e);
			if(bcnt == cnt - 1) break;
		}
//		System.out.println(cnt);
//		System.out.println(Arrays.toString(parent));
		
		int p = 0;
		for(int i = 0; i < cnt; i++) {
			if(parent[i] == i) p++;
		}
		if(p > 1) weight = 0;
		System.out.println(weight == 0 ? -1 : weight);
	}

	private static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static int weight;
	static int bcnt;
	private static void unionSet(Edge e) {
		int x = findSet(e.x);
		int y = findSet(e.y);
		
		if(x != y) {
			parent[x] = y;
			weight += e.weight;
			bcnt++;
		}
	}

	private static void findEdge(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int tx = x;
			int ty = y;
			int weight = 0;

			while (true) {
				tx += dx[i];
				ty += dy[i];

				if (tx < 0 || ty < 0 || tx >= N || ty >= M) break;
				if (map[tx][ty] == map[x][y]) break;
				if (map[tx][ty] != 0) {
					if(weight == 1) break;
//					System.out.printf("x,y = %d, %d || tx, ty = %d, %d\n", x, y, tx, ty);
					tree.add(new Edge(map[x][y] - 1, map[tx][ty] - 1, weight));
					break;
				}
				weight++;
			}
		}

	}

	private static void islandCounting(boolean[][] visited, int x, int y) {
		Queue<Edge> q = new LinkedList<>();
		q.add(new Edge(x, y));
		while (!q.isEmpty()) {
			Edge temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];

				if (tx < 0 || ty < 0 || tx >= N || ty >= M)
					continue;
				if (visited[tx][ty] || map[tx][ty] == 0)
					continue;

				visited[tx][ty] = true;
				map[tx][ty] = cnt;
				q.add(new Edge(tx, ty));
			}
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

		public Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight < o.weight ? -1 : 1;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + ", w=" + weight + "]";
		}

	}
}
