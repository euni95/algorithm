import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2630_색종이만들기 {
	static int[][] paper;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, N - 1, N - 1);
		System.out.println(white);
		System.out.println(blue);
	}

	static int white = 0;
	static int blue = 0;
	private static void check(int si, int sj, int ei, int ej) {
		int area = (ei - si + 1) * (ej - sj + 1);
		int cnt = 0;
		for(int i = si; i <= ei; i++) {
			for(int j = sj; j <= ej; j++) {
				if(paper[i][j] == 1) cnt++;
			}
		}
		if(cnt == 0) white++;
		else if(cnt == area) blue++;
		else cut(si, sj, ei, ej);
	}

	private static void cut(int si, int sj, int ei, int ej) {
		if(si >= ei || sj >= ej) return;
		
		int mi = (si+ei)/2 , mj = (sj+ej)/2;
		check(si, sj, mi, mj);
		check(si, mj + 1, mi, ej);
		check(mi + 1, sj, ei, mj);
		check(mi + 1, mj + 1, ei, ej);
	}
}
