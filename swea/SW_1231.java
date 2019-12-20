package fri_0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1231 { //[S/W 문제해결 기본] 9일차 - 중위순회
	static int N;
	static char[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N+1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				arr[num] = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) st.nextToken();
			}
			System.out.print("#" + t + " ");
			inOrder(1);
			System.out.println();
		}
	}
	public static void inOrder(int start) {
		if (start > N) {
			return;
		}
		inOrder(start * 2);
		System.out.print(arr[start]);
		inOrder(start * 2 + 1);
	}
}
