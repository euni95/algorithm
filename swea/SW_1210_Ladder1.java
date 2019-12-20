

import java.util.Scanner;

public class SW_1210_Ladder1 { // [S/W 문제해결 기본] 2일차 - Ladder1
	static int[] posX = {0, 0, -1};
	static int[] posY = {-1, 1, 0};
	static int[][] labber = new int[102][102];
	static int x, y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			sc.nextInt();
			//사다리 입력
			for(int i = 1; i < labber.length-1; i++) {
				for(int j = 1; j < labber.length-1; j++) {
					labber[i][j] = sc.nextInt();
					if(labber[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			System.out.println("#"+t+" "+test(x,y));
		}
		
		sc.close();
	}
	
	static int test(int a, int b) {
		int idxX, idxY;
		int pos = 0;
		int result = 0;
		while(true) {
			idxX = a + posX[pos];
			idxY = b + posY[pos];
			
			if(idxX == 0) {
				result = idxY;
				return result-1;
			}
			
			if(labber[idxX][idxY] == 1) {
				a = idxX;
				b = idxY;
				
				if(pos == 2) {
						if(labber[a+posX[0]][b+posY[0]] == 1) pos = 0;
						else if(labber[a+posX[1]][b+posY[1]] == 1) pos = 1;
				}
				continue;
			}
			
			pos = 2;
		}
	}
}
