
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class J_2543_타일채우기_갓균 {

	static int N;
	static int toilet[][];

	// 타일의 상대 좌표를 저장한다.
	static int tiles[][][] = { { { 0, 1 }, { 1, 1 }, { 1, 0 } }, // 1번 타일
			{ { 0, 0 }, { 1, 0 }, { 1, 1 } }, // 2번 타일
			{ { 0, 0 }, { 0, 1 }, { 1, 1 } }, // 3번 타일
			{ { 0, 0 }, { 0, 1 }, { 1, 0 } } // 4번 타일
	};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line[] = null;

		N = Integer.parseInt(in.readLine());

		toilet = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				toilet[i][j] = -1;

		line = in.readLine().split(" ");
		int X = Integer.parseInt(line[0]);
		int Y = Integer.parseInt(line[1]);
		toilet[X][Y] = 0;

		solve(0, 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				out.write(toilet[i][j] + " ");
			out.newLine();
		}

		out.flush();
	}

	// sx, sy : 현재 영역의 왼쪽 상단 좌표
	// L : 현재 영역의 가로, 세로 길이
	static void solve(int sx, int sy, int L) {
		// 길이 L이 최소 2이상이 되어야 계산이 가능하다.
		if (L == 1)
			return;

		// 비지 않은 사분면을 확인한다.
		// 우연의 일치로 비지 않은 사분면의 번호가 곧 붙여할 타일의 번호가 된다.
		int tileNum = findNotEmptyArea(sx, sy, L);

		// 현재 영역의 중앙에 해당되는 타일을 붙인다.
		for (int i = 0; i < 3; i++) {
			int nx = (sx + L / 2 - 1) + tiles[tileNum - 1][i][0];
			int ny = (sy + L / 2 - 1) + tiles[tileNum - 1][i][1];
			toilet[nx][ny] = tileNum;
		}
		
		// 각 사분면으로 문제를 분할한다.
		solve(sx, sy, L / 2);
		solve(sx + L / 2, sy, L / 2);
		solve(sx, sy + L / 2, L / 2);
		solve(sx + L / 2, sy + L / 2, L / 2);
	}

	// 전체 영역을 사분면으로 나누었을 때 비지 않은 사분면이 어느 것인지 반환한다.
	static int findNotEmptyArea(int sx, int sy, int L) {
		int x = -1;
		int y = -1;

		for (int i = sx; i < sx + L; i++) {
			for (int j = sy; j < sy + L; j++) {
				if (toilet[i][j] >= 0) {
					x = i;
					y = j;
					break;
				}
			}

			if (x != -1 && y != -1)
				break;
		}

		// (x, y)가 어느 사분면에 속해있는지 계산한다.
		int result = -1;
		if (sx <= x && x < sx + L / 2) result = ((sy <= y && y < sy + L / 2) ? 1 : 2);
		else result = ((sy <= y && y < sy + L / 2) ? 3 : 4);

		return result;
	}
}