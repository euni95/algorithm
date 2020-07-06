package answer;
import java.util.Scanner;

//3234. 준환이의 양팔저울 D4
public class SW_3234_준환이의양팔저울_answer {
	static int result;

	public static void main(String[] args) {
//        System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] weight = new int[N];
			for (int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
			}
			result = 0;
//            dfs로 모든경우 발생,
//            check 부울린 배열  static  영역에 만들고 공유하니 시간초과로 터지는 경우가 있었습니다.
			dfs(weight, new boolean[N], 0, 0, 0);
			System.out.println("#" + test_case + " " + result);
		}
	}

	static void dfs(int[] weight, boolean[] check, int left, int right, int depth) {
		if (left < right)
			return; // 오른쪽이 더 무거우면 나머지 실행 안함
		if (weight.length == depth) {
			result++;
			return;
		}
		for (int i = 0; i < weight.length; i++) {
			if (check[i]) continue;
			check[i] = true;
			dfs(weight, check, left + weight[i], right, depth + 1);
			dfs(weight, check, left, right + weight[i], depth + 1);
			check[i] = false;
		}
	}
}
