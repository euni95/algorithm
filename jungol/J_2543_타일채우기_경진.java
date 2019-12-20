
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J_2543_타일채우기_경진 {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		arr[y][x] = -1;
		slice(0, 0, n);
		arr[y][x] = 0;
		for (int[] a : arr) {
			for (int ar : a) {
				System.out.print(ar + " ");
			}
			System.out.println();
		}
	}

	private static void slice(int y, int x, int size) {
		int[][] idx = new int[4][];
		idx[0] = new int[] { y, x };
		idx[1] = new int[] { y + size / 2, x };
		idx[2] = new int[] { y, x + size / 2 };
		idx[3] = new int[] { y + size / 2, x + size / 2 };

		f: for (int k = 0; k < 4; k++) {
			int ty = idx[k][0];
			int tx = idx[k][1];
			
			for (int i = ty; i < ty + size / 2; i++) {
				for (int j = tx; j < tx + size / 2; j++) {
					if (arr[i][j] != 0) {
						switch (k) { // 0 왼쪽위 1 왼쪽아래 2 오른쪽위 3 오른쪽아래
						case 0:
							arr[ty + size / 2 - 1][tx + size / 2] = 1;
							arr[ty + size / 2][tx + size / 2 - 1] = 1;
							arr[ty + size / 2][tx + size / 2] = 1;
							break;
						case 1:
							arr[ty - 1][tx + size / 2 - 1] = 3;
							arr[ty - 1][tx + size / 2] = 3;
							arr[ty][tx + size / 2] = 3;
							break;
						case 2:
							arr[ty + size / 2 - 1][tx - 1] = 2;
							arr[ty + size / 2][tx - 1] = 2;
							arr[ty + size / 2][tx] = 2;
							break;
						case 3:
							arr[ty - 1][tx - 1] = 4;
							arr[ty - 1][tx] = 4;
							arr[ty][tx - 1] = 4;
							break;
						}
						break f;
					}
				}
			}
		}

		if (size > 2) {
			slice(y, x, size / 2);
			slice(y + size / 2, x, size / 2);
			slice(y, x + size / 2, size / 2);
			slice(y + size / 2, x + size / 2, size / 2);
		}
	}
}
