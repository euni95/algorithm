import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_16571_알파틱택톡_X {
	static int[][] pan;
	static char result = 'D';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		pan = new int[3][3];
		int cntX = 0, cntO = 0;
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if(pan[i][j] == 1) cntX++;
				else if(pan[i][j] == 2) cntO++;
			}
		}
		
		int player = 1;
		if(cntO < cntX) player = 2;
		
		int attack = player;
		int win = -1;
		int zeroCnt = 0;
		exit : while(true) {
			int tempX = -1, tempY = -1;
			
			// 가로 확인
			for(int i = 0; i < 3; i++) {
				int[] check = new int[3];
				for(int j = 0; j < 3; j++) {
					check[pan[i][j]]++;
				}
				
				if(check[0] == 1 && check[attack] == 2) {
					win = attack;
					break exit;
				}
				
				if((check[attack == 1 ? 2 : 1] == 2 && check[0] == 1) || (check[attack] == 1 && check[0] == 2) || (check[attack] == 1 && check[0] == 1)) {
					for(int j = 0; j < 3; j++) {
						if(pan[i][j] == 0) {
							tempX = i; tempY = j;
						}
					}
				}
				zeroCnt += check[0];
			}
			
			// 세로 확인
			for(int j = 0; j < 3; j++) {
				int[] check = new int[3];
				for(int i = 0; i < 3; i++) {
					check[pan[i][j]]++;
				}
				
				if(check[0] == 1 && check[attack] == 2) {
					win = attack;
					break exit;
				}
				
				if((check[attack == 1 ? 2 : 1] == 2 && check[0] == 1) || (check[attack] == 1 && check[0] == 2)) {
					for(int i = 0; i < 3; i++) {
						if(pan[i][j] == 0) {
							tempX = i; tempY = j;
						}
					}
				}
				zeroCnt += check[0];
			}
			
			// / 확인
			int[] check = new int[3];
			for(int i = 0; i < 3; i++) {
				check[pan[i][i]]++;
			}
			
			if(check[0] == 1 && check[attack] == 2) {
				win = attack;
				break exit;
			}
			
			if((check[attack == 1 ? 2 : 1] == 2 && check[0] == 1) || (check[attack] == 1 && check[0] == 2)) {
				for(int i = 0; i < 3; i++) {
					if(pan[i][i] == 0) {
						tempX = i; tempY = i;
					}
				}
			}
			zeroCnt += check[0];
			
			// \ 확인
			check = new int[3];
			for(int i = 0; i < 3; i++) {
				check[pan[i][2-i]]++;
			}
			
			if(check[0] == 1 && check[attack] == 2) {
				win = attack;
				break exit;
			}
			
			if((check[attack == 1 ? 2 : 1] == 2 && check[0] == 1) || (check[attack] == 1 && check[0] == 2)) {
				for(int i = 0; i < 3; i++) {
					if(pan[i][2-i] == 0) {
						tempX = i; tempY = 2-i;
					}
				}
			}
			zeroCnt += check[0];
			
			if(zeroCnt == 0) break;
			if(tempX == -1) {
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						if(pan[i][j] == 0) {
							tempX = i;
							tempY = j;
							break;
						}
					}
				}
			}
			pan[tempX][tempY] = attack;
			attack = attack == 1 ? 2 : 1;
		}
		
		if(win == -1) System.out.println('D');
		else if(win == player) System.out.println('W');
		else System.out.println('L');
	}
	
	static void print() {
		for(int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(pan[i]));
		}
	}
}
