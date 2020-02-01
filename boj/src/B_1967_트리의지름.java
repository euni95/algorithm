import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1967_트리의지름 {
	static int n;
	static ArrayList<Point>[] list;
	static int[] weight, child;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[p].add(new Point(c, w));
			list[c].add(new Point(p, w));
		}
		BFS(1);
		BFS(result_idx);
		System.out.println(max);
	}
	static int max, result_idx;
	private static void BFS(int start) {
		Queue<Point> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		q.add(new Point(start, 0));
		visited[start] = true;
		max = 0;
		while(!q.isEmpty()) {
			Point temp = q.poll();
			if(max < temp.weight) {
				max = temp.weight;
				result_idx = temp.idx;
			}
			for(int i = 0; i < list[temp.idx].size(); i++) {
				Point t = list[temp.idx].get(i);
				if(visited[t.idx]) continue;
				visited[t.idx] = true;
				q.add(new Point(t.idx, temp.weight + t.weight));
			}
		}
	}
	
	static class Point {
		int idx, weight;

		public Point(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
}
