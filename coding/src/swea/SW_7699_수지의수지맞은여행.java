package A_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SW_7699_수지의수지맞은여행 {
	static int R, C;
	static char[][] island;
	static Set<Character> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			island = new char[R][C];
			set = new HashSet<>();
			for (int i = 0; i < R; i++) {
				island[i] = br.readLine().toCharArray();
			}

			set = new HashSet<>();
			cnt = 0;
			set.add(island[0][0]);
			trip(0, 0);

			System.out.println("#" + t + " " + cnt);
		}
	}

	static int cnt = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int max;
	private static void trip(int x, int y) {
		set.add(island[x][y]);
		
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];

			if (!(tx < 0 || ty < 0 || tx >= R || ty >= C) && !set.contains(island[tx][ty])) {
				trip(tx, ty);
			}
		}
		
		if (set.size() > cnt)
			cnt = set.size();
		set.remove(island[x][y]);
	}
}
