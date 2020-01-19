import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11724_연결요소의개수 {
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) parent[i] = i;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			unionSet(num1, num2);
		}
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(parent[i] == i) cnt++;
		}
		System.out.println(cnt);
	}

	private static void unionSet(int num1, int num2) {
		num1 = findSet(num1);
		num2 = findSet(num2);
		
		if(num1 != num2) {
			parent[num2] = num1;
		}
	}

	private static int findSet(int num) {
		if(parent[num] == num) return num;
		else {
			int temp = findSet(parent[num]);
			parent[num] = temp;
			return temp;
		}
	}
	
}
