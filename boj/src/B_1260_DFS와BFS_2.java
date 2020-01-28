import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1260_DFS와BFS_2 {
	static int N, M, V;
	static StringBuilder sb;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		visited = new boolean[N + 1];
		visited[V] = true;
		sb.append(V).append(" ");
		DFS(V);
		sb.append("\n");
		BFS(V);
		System.out.println(sb);
	}

	private static void BFS(int idx) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N + 1];
		q.add(idx);
		visited[idx] = true;
		while(!q.isEmpty()) {
			int poll = q.poll();
			sb.append(poll).append(" ");
			for(int i = 0; i < list[poll].size(); i++) {
				int temp = list[poll].get(i);
				if(visited[temp]) continue;
				visited[temp] = true;
				q.add(temp);
			}
		}
		sb.append("\n");
	}

	private static void DFS(int idx) {
		for(int i = 0; i < list[idx].size(); i++) {
			int temp = list[idx].get(i);
			if(visited[temp]) continue;
			visited[temp] = true;
			sb.append(temp).append(" ");
			DFS(temp);
		}
	}

}
