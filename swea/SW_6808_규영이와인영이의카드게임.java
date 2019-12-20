import java.util.Scanner;

public class SW_6808_규영이와인영이의카드게임 { // 규영이와 인영이의 카드게임
	static int[] card;
	static int[] kyu;
	static int kyoTotalWin;
	static int kyoTotalLose;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			kyu = new int[9];
			int[] in = new int[9];
			card = new int[19];
			kyoTotalWin = 0;
			kyoTotalLose = 0;

			for (int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
				card[kyu[i]] = 1;
			}

			int j = 0;
			for (int i = 1; i < 19; i++) {
				if (card[i] == 1)
					continue;
				in[j++] = i;
			}

			perm(in, 0);
			System.out.println("#" + t + " " + kyoTotalWin + " " + kyoTotalLose);
		}
	}

	private static void perm(int[] in, int idx) {
		if (idx == in.length) {
			cardGame(in);
			return;
		}

		for (int i = idx; i < in.length; i++) {
			swap(in, idx, i);
			perm(in, idx + 1);
			swap(in, idx, i);
		}
	}

	static void cardGame(int[] in) {
		int inScore = 0;
		int kyoScore = 0;

		for (int i = 0; i < in.length; i++) {
			if (kyu[i] > in[i]) {
				kyoScore += kyu[i] + in[i];
			} else if (in[i] > kyu[i]) {
				inScore += kyu[i] + in[i];
			}
		}

		if (kyoScore > inScore)
			kyoTotalWin++;
		else if (kyoScore < inScore)
			kyoTotalLose++;
	}

	static void swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
