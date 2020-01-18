import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10819_차이를최대로 {
	static int N;
	static int[] input;
	static int[] output;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		output = new int[N];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
		perm(0);
		System.out.println(max);
	}
	static int max = Integer.MIN_VALUE;
	private static void perm(int depth) {
		if(depth == N) {
			int result = calc();
			if(result > max) max = result;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = input[i];
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
	private static int calc() {
		int sum = 0;
		for(int i = 0; i < N - 1; i++) {
			sum += Math.abs(output[i] - output[i + 1]); 
		}
		return sum;
	}

}
