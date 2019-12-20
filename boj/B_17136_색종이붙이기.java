import java.util.Scanner;

public class B_17136_색종이붙이기 { // 색종이 붙이기
	static int[][] paper;
	static int[] piece = { 5, 5, 5, 5, 5 };
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		paper = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				paper[i][j] = sc.nextInt();
		}

		for (int num = 5; num > 0; num--) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					solve(num, i, j);
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (paper[i][j] == 1)
					count = -1;
			}
		}

		System.out.println(count);
	}

	static void solve(int num, int x, int y) {
		boolean check;

		check = true;

		if (piece[num - 1] != 0 && 10 - x >= num && 10 - y >= num) {

			for (int i = x; i < x + num; i++) {
				for (int j = y; j < y + num; j++) {
					if (paper[i][j] == 0) {
						check = false;

					}

				}
			}

			if (check == true) {
				piece[num - 1]--;
				count++;
				for (int i = x; i < x + num; i++) {
					for (int j = y; j < y + num; j++) {
						paper[i][j] = 0;
					}
				}
			}
		}
	}
}
