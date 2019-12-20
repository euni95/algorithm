import java.util.Arrays;

public class permutation { // 순열

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4};
		// 1, 2, 3
		// 1, 3, 2
		// 2, 1, 3
		// 2, 3, 1
		// 3, 1, 2
		// 3, 2, 1
		v = new boolean[arr.length];
		copy = new int[arr.length];
		perm(arr, 0);
		System.out.println(cnt);
	}
	static int[] copy;
	static boolean[] v;
	static int cnt;
	private static void perm(int[] arr, int depth) {
		if (depth == arr.length) {
			System.out.println(Arrays.toString(copy));
			cnt++;
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(v[i]) continue;
			v[i] = true;
			copy[depth] = arr[i];
			perm(arr, depth + 1);
			v[i] = false;
		}
	}

}
