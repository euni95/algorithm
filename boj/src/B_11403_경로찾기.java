import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_11403_경로찾기 {
	static int N;
	static int[][] result;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		result = new int[N][N];
		list = new ArrayList[N];
		for(int i = 0; i < N; i++) list[i] = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) list[i].add(j);
			}
		}
		for(int i = 0; i < N; i++) bfs(i);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			} sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		while(!q.isEmpty()) {
			int poll = q.poll();
			for(int i = 0; i < list[poll].size(); i++) {
				int temp = list[poll].get(i);
				if(result[idx][temp] == 1) continue;
				result[idx][temp] = 1;
				q.add(temp);
			}
		}
	}
}
