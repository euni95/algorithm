import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_7465_창용마을무리의개수2 {
	static int[] relation;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 창용 마을에 사는 사람의 수
			M = Integer.parseInt(st.nextToken()); // 서로를 알고 있는 사람의 수

			relation = new int[N + 1];
			for (int i = 0; i <= N; i++) relation[i] = i;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				uion(a, b);
			}
			
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(relation[i] == i) cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

	private static void uion(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) relation[b] = a;
	}

	private static int find(int a) {
		if(relation[a] == a) return a;
		else {
			int b = find(relation[a]);
			relation[a] = b;
			return b;
		}
	}

}
