import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_1225_암호생성기 { // [S/W 문제해결 기본] 7일차 - 암호생성기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();

		for (int t = 1; t <= 10; t++) {
			int tNum = sc.nextInt();

			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			
			int cnt = 1;
			while(true) {
				if(cnt > 5) cnt = 1;
				int num = q.poll() - cnt;
				if(num <= 0) {
					q.offer(0);
					break;
				}
				q.offer(num);
				
				cnt++;
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}


}
