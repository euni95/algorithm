import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14889_스타트와링크 {
	static int N;
	static int[][] team;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 총 인원 (짝수)
		team = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int size = 1 << N; // 2^N
		boolean[] check = new boolean[N];
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < size/2 - 1; i++) {
			int cnt = 0;
			Arrays.fill(check, false);
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) == 0) {
					check[j] = true;
					cnt++;
				}
			}

			int team1 = 0;
			int team2 = 0;
			if(cnt == N/2) {
				for(int s = 0; s < N; s++) {
					for(int k = 0; k < N; k++) {
						if(s == k) continue;
						if(check[s] && check[k]) {
							team1 += team[s][k];
						} 
						else if(!check[s] && !check[k]){
							team2 += team[s][k];
						}
					}
				}
				min = Math.min(min, Math.abs(team1 - team2));
			}
		}
		System.out.println(min);
	}

}
