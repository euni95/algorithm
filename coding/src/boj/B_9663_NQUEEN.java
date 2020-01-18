
import java.util.Scanner;

public class B_9663_NQUEEN { // N-Queen _ 내가 다시 푼 것
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cnt = 0;
		N = sc.nextInt();

		int[] arr = new int[N];
		backTracking(arr, 0);
		System.out.println(cnt);
	}

	static int cnt = 0;

	private static void backTracking(int[] arr, int idx) {
		if (idx == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[idx] = i;
			if (check(arr, idx)) {
				backTracking(arr, idx + 1);
			}
		}
	}

	private static boolean check(int[] arr, int idx) {
		boolean flag = true;

		for (int i = 0; i < idx; i++) {
			if (arr[idx] == arr[i]) {
				flag = false;
				break;
			}
			if ((idx - i) == Math.abs(arr[idx] - arr[i])) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
