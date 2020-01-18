import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1697_숨바꼭질 { // 190812_숨바꼭질
	static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		bfs(N, K);
		System.out.println(size);
	}

	private static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		boolean[] visited = new boolean[1000001];
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				n = q.poll();

				if (n == k) {
					return;
				}
				if (n + 1 <= 1000000 && !visited[n + 1]) {
					q.add(n + 1);
					visited[n + 1] = true;
				}
				if (n * 2 <= 1000000 && !visited[n * 2]) {
					q.add(n * 2);
					visited[n * 2] = true;
				}
				if (n - 1 >= 0 && !visited[n - 1]) {
					q.add(n - 1);
					visited[n - 1] = true;
				}
			}
			size++;
		}
	}
}
