import java.util.Scanner;

public class SW_1204_최빈수구하기 { //[S/W 문제해결 기본] 1일차 - 최빈수 구하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tNum, score;
		int[] scores;
		for(int i = 0; i < T; i++) {
			tNum = sc.nextInt();
			
			scores= new int[101];
			for(int j = 0; j < 1000; j++) {
				score = sc.nextInt();
				scores[score]++;
			}
			int max_num = 0;
			int max_score = 0;
			for(int j = 1; j < 101; j++) {
				if(max_num <= scores[j]) {
					max_num = scores[j];
					max_score = j;
				}
			}
			System.out.println("#" + tNum + " " + max_score);
		}
		sc.close();
	}

}
