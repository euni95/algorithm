import java.util.Scanner;

public class SW_5431_민석이의과제체크 { //민석이의 과제 체크하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		int K;
		int number;
		int[] submit;
		
		for(int i = 0; i < T; i++) {
			N = sc.nextInt(); //수강생 수
			K = sc.nextInt(); //제출자 수 

			submit = new int[N+1];
			for(int j = 0; j < K; j++) {
				number = sc.nextInt();
				submit[number] = 1;
			}
			
			System.out.print("#" + (i+1) +" ");
			for(int j = 1; j < N+1; j++) {
				if(submit[j] == 1) continue;
				System.out.print(j + " ");
			}System.out.println();
		}
		sc.close();
	}
}
