import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14938_서강그라운드 {
	static int n, m, r;
	static ArrayList<Point>[] list;
	static int[] item;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		item = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) item[i] = Integer.parseInt(st.nextToken());
			
		list = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list[a].add(new Point(b, len));
			list[b].add(new Point(a, len));
		}
		
		for(int i = 1; i <= n; i++) {
			bfs(i);
		}
		System.out.println(max);
	}
	static int max;
	private static void bfs(int start) {
		Queue<Point> q = new LinkedList<>();
		int[] save = new int[n+1];
		boolean[] visited = new boolean[n+1];
		Arrays.fill(save, 7654321);
		save[start] = 0;
		q.add(new Point(start, 0));
		int sum = 0;
		while(!q.isEmpty()) {
			Point poll = q.poll();
			int t_road = poll.road;
			if(!visited[t_road]) {
				visited[t_road] = true;
				sum += item[t_road];
			}

			for(int i = 0; i < list[t_road].size(); i++) {
				Point temp = list[t_road].get(i);
				int t_len = temp.length + poll.length;
				if(t_len > m) continue;
				if(save[temp.road] <= t_len) {
					continue;
				}
				save[temp.road] = t_len;
				q.add(new Point(temp.road, t_len));
			}
		}
		max = Math.max(max, sum);
	}

	static class Point {
		int road, length;

		public Point(int road, int length) {
			this.road = road;
			this.length = length;
		}
		
	}
}
