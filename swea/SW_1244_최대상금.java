import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1244_최대상금 { // [S/W 문제해결 응용] 2일차 - 최대 상금
	static char[] nums;
	static int max;
	static int numsLen;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			max = 0;
			String input[] = br.readLine().split(" ");
			nums = input[0].toCharArray();
			cnt = Integer.parseInt(input[1]);

			numsLen = nums.length;
			boolean[][] visited = new boolean[cnt + 1][1000000];
			check(visited, 0);

			System.out.println("#" + t + " " + max);
		}
	}

	private static void check(boolean[][] visited, int count) {
		if (count == cnt) {
			int result = Integer.valueOf(String.valueOf(nums));
			if (max < result)
				max = result;
			return;
		}
		for (int i = 0; i < numsLen - 1; i++) {
			for (int j = i + 1; j < numsLen; j++) {
				swap(i, j);
				int num = Integer.valueOf(String.valueOf(nums));
				if (!visited[count][num]) {
					visited[count][num] = true;
					check(visited, count + 1);
				}
				swap(i, j);
			}
		}
	}

	private static void swap(int i, int j) {
		char temp;
		temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
