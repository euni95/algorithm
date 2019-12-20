import java.util.Scanner;

public class SW_1217_거듭제곱 { // [S/W 문제해결 기본] 4일차 - 거듭 제곱

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = 10;
		
		for(int t = 1; t <= 10; t++) {
			int num = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#" + t + " " + pow(N, M));
		}
	}

	private static int pow(int n, int m) {
		if(m == 0) return 1;
		if(m == 1) return n;
		
		int num = pow(n, m/2);
		if(m % 2 == 0) return num * num;
		else return num * num * n;
	}

}
