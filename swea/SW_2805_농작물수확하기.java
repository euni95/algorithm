import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_2805_농작물수확하기 { // 농장물 수확하기

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		s = reader.readLine();
		int T = Integer.parseInt(s);

		for (int t = 1; t <= T; t++) {
			s = reader.readLine();
			int size = Integer.parseInt(s);
			int[][] map = new int[size+1][size+1];
			
			for (int i = 0; i < size; i++) {
				s = reader.readLine();
				for (int j = 0; j < size; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			int sum = 0; int cnt = 1;
			int start = size / 2;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (j == start) {
						for (int k = 0; k < cnt; k++) {
							sum += map[i][j];
							j++;
						} break;
					}
				}

				if (size / 2 > i) {
					cnt += 2; start--;
				} else {
					cnt -= 2; start++;
				}
			}
			System.out.println("#" + t + " " + sum);
		}

	}

}
