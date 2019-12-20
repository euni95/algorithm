package A_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SW_7699_수지의수지맞은여행_2_answer {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader reader = new BufferedReader(new FileReader("sample_input.txt"));
		int tc = Integer.parseInt(reader.readLine());

		
		String[] s =  null;
		int[][] map = null;
		boolean v[] =  null;
		for(int t = 1; t <= tc; t++) {
			max = -1;
			s = reader.readLine().split(" ");
			R = Integer.parseInt(s[0]);
			C = Integer.parseInt(s[1]);
			map = new int[R][C];
			for(int y = 0; y < R; y++) {
				s = reader.readLine().split("");
				for(int x = 0; x < C; x++) {
					map[y][x] = s[x].charAt(0) - 'A';
				}
			}
			v = new boolean[26];
			dfs(map, v, 0,0, 1);
			System.out.println("#"+t + " " + max);
		}
	}
	static int max , R,C;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	static void dfs(int[][] map, boolean[] v, int x, int y, int cnt) {
		
		if(max < cnt) {
			max = cnt;
			
		}if(max == 26) {
			return;
		}
		v[map[y][x]] = true;
		int tx, ty;
		for(int i = 0 ; i < 4; i++) {
			tx = x + dx[i];
			ty = y + dy[i];
			if(tx < 0 || tx >= C || ty < 0 || ty >= R) {
				continue;
			}
			if(v[map[ty][tx]]) {
				continue;
			}

			dfs(map, v, tx, ty, cnt + 1);
			v[map[ty][tx]] = false;
		}
	}
}