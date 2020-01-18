import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17825_주사위윷놀이 {
	static final int N = 10;
	static int[] dice, mal;
	static int[][] pan = { // 출발지 일 때 || 지나가는 중 일 때
			{ 1, 1 }, // 0
			{ 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 }, { 20, 6 }, // 5
			{ 7, 7 }, { 8, 8 }, { 9, 9 }, { 10, 10 }, { 26, 11 }, // 10
			{ 12, 12 }, { 13, 13 }, { 14, 14 }, { 15, 15 }, { 23, 16 }, // 15
			{ 17, 17 }, { 18, 18 }, { 19, 19 }, { 31, 31 }, { 21, 21 }, // 20
			{ 22, 22 }, { 28, 28 }, { 24, 24 }, { 25, 25 }, { 28, 28 }, // 25
			{ 27, 27 }, { 28, 28 }, { 29, 29 }, { 30, 30 }, { 31, 31 }, // 30
			{ 32, 32 } // 도착
	};
	static int[] scores = {
		0, 2, 4, 6, 8, 10, // 5 
		12, 14, 16, 18, 20, // 10
		22, 24, 26, 28, 30, // 15
		32, 34, 36, 38, 13, // 20
		16, 19, 28, 27, 26, // 25
		22, 24, 25, 30, 35, // 30
		40, 0
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		for (int i = 0; i < N; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		mal = new int[4];
		state = new int[10];
		combi(0);
		System.out.println(max);
	}
	
	static int[] state;
	static void combi(int cnt) {
		if(cnt == 10) {
			go();
			return;
		}
		for(int i = 0; i < 4; i++) {
			state[cnt] = i;
			combi(cnt + 1);
		}
	}
	static int max;
	private static void go() {
		int score = 0;
		for(int i = 0; i < 4; i++) mal[i] = 0;
		
		boolean check = false;
		aa : for(int i = 0; i < N; i++) {
			int temp = mal[state[i]]; // 현재 말의 위치
			for(int j = 0; j < dice[i]; j++) {
				if(temp == 32) break;
				
				if(j == 0) temp = pan[temp][0];
				else temp = pan[temp][1];
			}
			for(int j = 0; j < 4; j++) {
				if(j == state[i]) continue;
				if(mal[j] == temp && temp != 32) {
					check = true;
					break;
				}
			}
			if(check) break aa;
			score += scores[temp];
			mal[state[i]] = temp;
		}
		if(check) return;
		max = Math.max(max, score);
	}
}
