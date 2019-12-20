import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_10974_모든순열 {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		output = new int[N];
		
		perm(0);
	}
	static boolean[] visited;
	static int[] output;
	private static void perm(int depth) {
		if(depth == N) {
			for(int i = 0; i < N; i++) System.out.print(output[i] + " ");
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			output[depth] = i + 1;
			visited[i] = true;
			perm(depth + 1);
			visited[i] = false;
		}
	}

}
