package A_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2615_오목 {
	static int[][] go;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		go = new int[19][19];
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				go[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		loop : for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(go[i][j] != 0) check(i, j);
				if(five) {
					System.out.println(go[i][j]);
					System.out.println((i+1) + " " + (j+1));
					break loop;
				}
			}
		}
		if(!five) System.out.println(0);
	}
	// 밑, 오밑, 오옆, 오위 | 위, 왼위, 왼옆, 왼밑
	static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1}; 
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static boolean five;
	static void check(int x, int y) {
		int tx, ty;
		int temp = go[x][y];
		
		for(int i = 0; i < 4; i++) {
			five = false;
			
			// 반대방향 확인
			tx = x + dx[i + 4];
			ty = y + dy[i + 4];
			
			if(tx >= 19 || ty >= 19) break;
			if(tx >= 0 && ty >= 0 && go[tx][ty] == temp) {
				continue;
			}
			tx = x; ty = y;
			for(int j = 0; j < 5; j++) {
				tx += dx[i];
				ty += dy[i];
				if(tx < 0 || ty < 0 || tx >= 19 || ty >= 19) break;
				if(go[tx][ty] != temp) break;
				if(j == 3) five = true;
				if(j == 4) five = false;
			}
			if(five) return;
		}
	}

}
