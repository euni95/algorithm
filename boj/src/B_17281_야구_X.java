import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B_17281_야구_X {
	static int N;
	static int[][] score;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 이닝 수
		score = new int[N][9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order = new int[9];
		order[3] = 0;
		visited = new boolean[9];
		visited[3] = true;
		perm(0);
		System.out.println(totalScore);
	}
	
	static int totalScore;
	private static void game() {
		int bat = order[0];
		int inning = 0, one = -1, two = -1, three = -1, out = 0;
		int sum = 0;
		while(true) {
			int result = score[inning][bat];
			if(result == 1) {
				if(three != -1) sum++;
				three = two;
				two = one;
				one = bat;
			}
			if(result == 2) {
				if(two != -1) sum++;
				if(three != -1) sum++;
				three = one;
				two = bat;
				one = -1;
			}
			if(result == 3) {
				if(one != -1) sum++;
				if(two != -1) sum++;
				if(three != -1) sum++;
				three = bat;
				two = -1;
				one = -1;
			}
			if(result == 4) {
				if(one != -1) sum++;
				if(two != -1) sum++;
				if(three != -1) sum++;
				sum++;
				one = two = three = -1;
			}
			if(result == 0) {
				out++;
			}
			bat = (bat + 1) % 9;
			
			if(out == 3) {
				inning++;
				out = 0;
				one = two = three = -1;
			}
			if(inning == N) break;
		}
		totalScore = Math.max(totalScore, sum);
	}
	
	// 타순 정하기
	static int[] order;
	static boolean[] visited;
	private static void perm(int cnt) {
		if(cnt == 9) {
			game();
			return;
		}
		if(cnt == 3) {
			perm(cnt + 1);
			return;
		}
		for(int i = 1; i < 9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			order[cnt] = i;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}
