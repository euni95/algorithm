import java.util.Scanner;

public class SW_1208_Flatten { // [S/W 문제해결 기본] 1일차 - Flatten

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int i = 1; i <= T; i++) {
			int dumpCnt;
			int box[] = new int[100];
			int max = 0, max_index = -1;
			int min = 101, min_index = -1;
			
			dumpCnt = sc.nextInt(); //dump 횟수 입력
			
			for(int j = 0; j < 100; j++) box[j] = sc.nextInt(); //box값 입력

			for(int j = 0; j <= dumpCnt; j++) { // dump 횟수 + 마지막 dump후 min, max를 확인
				max = 0;	//min, max 초기화
				min = 101;
				for(int k = 0; k < 100; k++) {
					if(box[k] < min) {
						min = box[k];
						min_index = k;
					}
					if(box[k] > max) {
						max = box[k];
						max_index = k;
					}
				}
				if(j==dumpCnt) continue;
				box[min_index]++;
				box[max_index]--;
			}
			
			System.out.println("#"+i+" "+ (box[max_index] - box[min_index]));
		}
		sc.close();
	}

}
