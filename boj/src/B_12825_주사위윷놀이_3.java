import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_12825_주사위윷놀이_3 {
	static int[] mal;
	static int[] pan = {
		0, 0, 0, 0, 0, 25, 0, 0, 0, 0, // 9
		37, 0, 0, 0, 0, 48, 0, 0, 0, 0, // 19
		55, -1, -1, -1, -1, 0, 0, 0, 0, 52, // 29
		53, 54, 55, -1, -1, -1, -1, 0, 0, 0, // 39
		52, 53, 54, 55, -1, -1, -1, -1, 0, 0, // 49
		0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1 // 60
	}, scores = {
		0, 2, 4, 6, 8, 10, 12, 14, 16, 18,
		20, 22, 24, 26, 28, 30, 32, 34, 36, 38,
		40, 0, 0, 0, 0, 10, 13, 16, 19, 25,
		30, 35, 40, 0, 0, 0, 0, 20, 22, 24,
		25, 30, 35, 40, 0, 0, 0, 0, 30, 28,
		27, 26, 25, 30, 35, 40, 0, 0, 0, 0, 0
	}, dice, order;
	static int maxScore;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		for(int i = 0; i < 10; i++) dice[i] = Integer.parseInt(st.nextToken());
		order = new int[10];
		makeOrder(0);
		System.out.println(maxScore);
	}
	private static void makeOrder(int idx) {
		if(idx == 10) {
			startGame();
			return;
		}
		for(int i = 0; i < 4; i++) {
			order[idx] = i;
			makeOrder(idx+1);
		}
	}
	private static void startGame() {
		mal = new int[4];
		int score = 0;
		for(int i = 0; i < 10; i++) {
			int temp = order[i];
			if(mal[temp] == -1) return;
			int next = dice[i] + mal[temp];
			
			if(pan[next] == -1) {
				mal[temp] = -1;
				continue;
			}
			if(pan[next] != 0) next = pan[next];
			for(int j = 0; j < 4; j++) {
				if(j == temp) continue;
				if(mal[j] == next) return;
			}
			score += scores[next];
			mal[temp] = next;
		}
		maxScore = Math.max(score, maxScore);
	}
}
