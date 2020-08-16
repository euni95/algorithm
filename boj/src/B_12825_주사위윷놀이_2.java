import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_12825_주사위윷놀이_2 {
	static int[][] mal, pan = { 
				{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },
				{ 10, 13, 16, 19, 25, 30, 35, 40 }, 
				{  0, 20, 22, 24, 25, 30, 35, 40 }, 
				{ 30, 28, 27, 26, 25, 30, 35, 40 }
			};
	static int[] dice, order;
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
		int score = 0;
		mal = new int[4][2];
		
		for(int i = 0; i < 10; i++) {
			int temp = order[i];
			int tx = mal[temp][0];
			int ty = mal[temp][1];
			if(tx == -1) return;
			
			int next = ty + dice[i];
			if(next >= pan[tx].length) {
				mal[temp][0] = -1;
				continue;
			}
			
//			System.out.println(temp);
//			System.out.println("before " + "(" + tx +  " , " + ty + ")");
			int nextVal = pan[tx][next];
			if(nextVal == 40) {
				tx = 0;
				ty = 20;
			} else if (tx == 0 && nextVal == 10) {
				tx = 1;
				ty = 0;
			} else if (tx == 0 && nextVal == 20) {
				tx = 2;
				ty = 1;
			} else if (tx == 0 && nextVal == 30) {
				tx = 3;
				ty = 0;
			}
			else {
				if(tx != 0 && next >= 4) {
					tx = 1;
				}
				ty = next;
			}
//			System.out.println("after" + "(" + tx + " , " + ty + ") " + nextVal);
			for(int j = 0; j < 4; j++) {
				if(temp == j) continue;
				if(tx == mal[j][0] && ty == mal[j][1]) return;
			}
			mal[temp][0] = tx;
			mal[temp][1] = ty;
			score += pan[tx][ty];
		}
		maxScore = Math.max(maxScore, score);
	}
}
