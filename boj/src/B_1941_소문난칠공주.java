import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1941_소문난칠공주 {
	static char[][] students;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static boolean[] v;
	static int cases;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		students = new char[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			students[i] = st.nextToken().toCharArray();
		}

		v = new boolean[1 << 25];
		int[] nodes = new int[7];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int idx = 1 << (i * 5 + j);
				v[idx] = true;
				
				nodes[0] = i * 5 + j;
				makeGroup( students[i][j] == 'Y' ? 1 : 0, idx, 1, nodes);
			}
		}
		System.out.println(cases);
	}

	private static void makeGroup(int doyeon, int visited, int cnt, int[] nodes) {
		if (cnt == 7) {
			cases++;
			System.out.println(Arrays.toString(nodes));
			return;
		}
		
//		for(int i = 0; i < 25; i++) {
		for(int i = 0; i < cnt; i++) {
//			if((visited & (1 << i)) == 0) continue;
			int temp = nodes[i];
			int x = temp / 5, y = temp % 5;
			
			for(int j = 0; j < 4; j++) {
				int tx = x + dx[j];
				int ty = y + dy[j];
				if (tx < 0 || ty < 0 || tx >= 5 || ty >= 5) continue;
				
				int idx = tx * 5 + ty;
				if ((visited & (1 << idx)) > 0) continue;

				int tempVisited = visited | (1 << idx);
				if (v[tempVisited]) continue;

				int tempDoyeon = (students[tx][ty] == 'Y' ? 1 : 0) + doyeon;
				if (tempDoyeon >= 4) continue;
				v[tempVisited] = true;
				
				nodes[cnt] = idx;
				makeGroup(tempDoyeon, tempVisited, cnt + 1, nodes);
			}
		}
	}
}
