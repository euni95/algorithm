import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16987_계란으로계란치기 {
	static int N;
	static int[][] eggs;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2]; // 내구도 , 무게
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		dfs(0);
		System.out.println(max);
	}
	static int max;
	private static void dfs(int idx) {
		if(idx == N) {
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if(eggs[i][0] <= 0) cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		if(eggs[idx][0] <= 0) { // 손에 들고 있는 계란이 깨졌을 때
			dfs(idx + 1);
			return;
		}
		
		boolean hit = false;
		for(int i = 0; i < N; i++) {
			if(i == idx || eggs[i][0] <= 0) continue; // 손에 든 계란이거나, 계란이 깨졌을 때
			hit = true;
			eggs[idx][0] -= eggs[i][1];
			eggs[i][0] -= eggs[idx][1];
			dfs(idx + 1);
			eggs[idx][0] += eggs[i][1];
			eggs[i][0] += eggs[idx][1];
		}
		if(!hit) dfs(idx + 1); // 깨지지 않은 다른 계란이 없으면 치지 않고 넘어감
	}
}
