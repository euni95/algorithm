import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1592_영식이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 인원 수
		int M = Integer.parseInt(st.nextToken()); // 최대 횟수

		// 횟수가 홀수면 시계방향으로 L, 짝수면 반시계방향으로 L번째
		int L = Integer.parseInt(st.nextToken());

		int[] table = new int[N];
		int idx = 0;
		table[idx] = 1;
		int cnt = 0;
		while (true) {
			if(table[idx] == M) {
				break;
			}
			
			if (table[idx] % 2 == 1) {
				idx += L;
				if(idx >= N) idx %= N;
				cnt++;
			}
			else {
				idx -= L;
				if(idx < 0) idx =  N + idx;
				cnt++;
			}
			table[idx]++;
			
		}
		System.out.println(cnt);
			
	}

}
