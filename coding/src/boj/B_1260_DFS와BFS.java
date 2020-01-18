import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B_1260_DFS와BFS { // DFS와 BFS

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();

		Graph graph = new Graph(N + 1);
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.addVer(a, b);
			graph.addVer(b, a);
		}
		graph.sort();
		graph.dfs(start);
		System.out.println();
		graph.bfs(start);

	}

	static class Graph {
		int size;
		LinkedList<Integer>[] list;
		boolean[] visited_dfs;
		
		public Graph(int size) {
			this.size = size;
			list = new LinkedList[size];
			visited_dfs = new boolean[size];
			
			for (int i = 0; i < size; i++) {
				list[i] = new LinkedList<Integer>();
			}
		}
		
		
		public void sort() {
			for(int i = 0; i < size - 1; i++) {
			Collections.sort(list[i]);
			}
		}


		public void dfs(int start) {
			System.out.print(start + " ");
			visited_dfs[start] = true;
			
			int point;
			Iterator<Integer> iterator = list[start].iterator();
			while (iterator.hasNext()) {
				point = iterator.next();
				if (!visited_dfs[point]) {
					dfs(point);
				}
			}
			
		}

		public void bfs(int start) {
			boolean[] visited = new boolean[size];
			Queue<Integer> q = new LinkedList<>();
			q.offer(start);
			visited[start] = true;

			while (!q.isEmpty()) {
				int idx = q.poll();
				System.out.print(idx + " ");

				int point;
				Iterator<Integer> iterator = list[idx].iterator();
				while (iterator.hasNext()) {
					point = iterator.next();
					if (!visited[point]) {
						q.offer(point);
						visited[point] = true;
					}
				}
			}
		}

		public void addVer(int i, int j) {
			list[i].add(j);
		}

	}
}
