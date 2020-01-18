import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_3124_최소스패닝트리_2_prim {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()) + 1; // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수
			
			ArrayList<Point>[] list = new ArrayList[V];
			for(int i = 0; i < V; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken()); // 가중치
				
				list[x].add(new Point(y, weight));
				list[y].add(new Point(x, weight));
			}
			
			PriorityQueue<Point> q = new PriorityQueue<>();
			int begin = 1;
			for(Point p : list[begin]) q.offer(p);
			boolean[] visited = new boolean[V+1];
			visited[begin] = true;
			
			Point temp;
			long weight = 0;
			int count = 0;
			while(!q.isEmpty()) {
				if(count == V - 1) break;
				
				temp = q.poll();
				if(visited[temp.x]) continue;
				weight += temp.weight;
				visited[temp.x] = true;
				count++;
				
				for(Point p : list[temp.x]) {
					q.offer(p);
				}
			}
			System.out.println("#" + t + " " + weight);
		}
	}

	static class Point implements Comparable<Point> {
		int x, weight;

		public Point(int x, int weight) {
			this.x = x;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return o.weight < this.weight ? 1 : -1;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", weight=" + weight + "]";
		}
		
	}

}
