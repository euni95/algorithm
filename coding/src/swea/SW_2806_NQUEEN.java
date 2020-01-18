import java.util.Scanner;

public class SW_2806_NQUEEN { // N-Queen
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			cnt = 0;
			N = sc.nextInt();

			int[] arr = new int[N];
			backTracking(arr, 0);
			System.out.println("#" + t + " " + cnt);
		}
	}

	static int cnt = 0;

	private static void backTracking(int[] arr, int depth) {
		if (depth == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[depth] = i;

			if (isPromising(arr, depth)) {
				backTracking(arr, depth + 1);
			}
		}

	}

	static boolean isPromising(int[] arr, int depth) {
		boolean flag = true;
		for (int i = 0; i < depth; i++) {
			if (arr[i] == arr[depth]) { // |
				flag = false;
				break;
			}
			if (Math.abs(arr[depth] - arr[i]) == (depth - i)) {
				flag = false;
				break;
			}
//			if((arr[depth] - arr[i]) == (depth - i)) {  // \ 대각선
//				flag = false;
//				break;
//			}
//			if((arr[i] - arr[depth]) == (depth - i)) {  // / 대각선
//				flag = false;
//				break;
//			}
		}
		return flag;
	}

	private static boolean check(int[] arr) {
		boolean flag = true;
		outer: for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] == arr[j]) { // |
					flag = false;
					break outer;
				}
				if ((arr[j] - arr[i]) == (j - i)) { // \ 대각선
					flag = false;
					break outer;
				}
				if ((arr[i] - arr[j]) == (j - i)) { // / 대각선
					flag = false;
					break outer;
				}
			}
		}
		return flag;
	}

}
