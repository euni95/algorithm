import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15685_드래곤커브 {
	static int N;
	static int[] dx = { 0, -1, 0, 1 }, dy = { 1, 0, -1, 0 }; // 오, 위, 왼, 아래

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		boolean[][] dragon = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()); // 드래곤 커브 x 좌표
			int x = Integer.parseInt(st.nextToken()); // 드래곤 커브 y 좌표
			int d = Integer.parseInt(st.nextToken()); // 시작 방향
			int g = Integer.parseInt(st.nextToken()); // 세대

			dragon[x][y] = true;
			dragon[x += dx[d]][y += dy[d]] = true;
			ArrayList<Integer> list = new ArrayList<>();
			list.add(d);
			for (int j = 0; j < g; j++) {
				int size = list.size();
				for(int k = size - 1; k >= 0; k--) {
					int dir = (list.get(k) + 1) % 4;
					dragon[x += dx[dir]][y += dy[dir]] = true;
					list.add(dir);
				}
			}
		}
		int result = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(dragon[i][j] && dragon[i+1][j] && dragon[i][j+1] && dragon[i+1][j+1]) result++;
			}
		}
		System.out.println(result);
	}
}
