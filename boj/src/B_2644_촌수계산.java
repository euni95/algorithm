import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2644_촌수계산 { //촌수 계산

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nop = sc.nextInt();
		int per1 = sc.nextInt();
		int per2 = sc.nextInt();
		int parent = 0;
		int child = 0;

		Graph graph = new Graph(nop + 1, per2);

		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			parent = sc.nextInt();
			child = sc.nextInt();
			graph.add(parent, child);
			graph.add(child, parent);
		}
		graph.bfs(per1);
	}

	static class Graph {
		int size;
		int per;
		LinkedList<Integer>[] list;

		public Graph(int size, int per) {
			this.size = size;
			this.per = per;
			list = new LinkedList[size];

			for (int i = 0; i < size; i++) {
				list[i] = new LinkedList<Integer>();
			}
		}

		public void add(int i, int j) {
			list[i].add(j);
		}

		public void bfs(int start) {
			boolean[] visited = new boolean[size];
			Queue<Integer> q = new LinkedList<>();
			q.offer(start);
			visited[start] = true;
			int degree = 1;
			boolean relation = false;
			int result = 0;

			while (!q.isEmpty()) {
				int qSize = q.size();

				for (int i = 0; i < qSize; i++) {
					int idx = q.poll();

					for (int j : list[idx]) {
						if (!visited[j]) {
							q.offer(j);
							visited[j] = true;
							if (j == per) {
								relation = true;
								result = degree;
							}
						}
					}
				}
				degree++;

			}
			if (relation)
				System.out.println(result);
			else
				System.out.println("-1");
		}

	}
}
