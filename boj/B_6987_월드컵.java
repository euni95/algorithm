import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_6987_월드컵 {
	static int[][] match;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			match = new int[6][3];
			int total = 0;
			for (int i = 0; i < 6; i++) {
				match[i][0] = Integer.parseInt(st.nextToken());
				match[i][1] = Integer.parseInt(st.nextToken());
				match[i][2] = Integer.parseInt(st.nextToken());
				total += match[i][0] + match[i][1] + match[i][2];
			}

			flag = false;
			if(total == 30) {
				game(0, 1);
			}
			System.out.print(flag ? "1 " : "0 ");

		}
	}

	static boolean flag;

	static void game(int i, int j) {

		if (i == 5) {
			flag = true;
			return;
		}

		if (j > 5) {
			// System.out.println(Arrays.toString(match[i]));
			game(i + 1, i + 2);
			return;
		}

		if (match[i][1] > 0 && match[j][1] > 0) {
			match[i][1]--;
			match[j][1]--;
			game(i, j + 1);
			match[i][1]++;
			match[j][1]++;
		}
		if (match[i][0] > 0 && match[j][2] > 0) {
			match[i][0]--;
			match[j][2]--;
			game(i, j + 1);
			match[i][0]++;
			match[j][2]++;
		}
		if (match[i][2] > 0 && match[j][0] > 0) {
			match[i][2]--;
			match[j][0]--;
			game(i, j + 1);
			match[i][2]++;
			match[j][0]++;
		}

	}
}
