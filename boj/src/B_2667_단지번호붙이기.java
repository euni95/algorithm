import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_2667_단지번호붙이기 { // 단지번호붙이기
	static int N;
	static int[][] map;
	static int cnt, num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				map[i][j] = line[j] - '0';
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		boolean visited[][] = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == true || map[i][j] == 0) continue;
				pot(i, j, visited);
				cnt++;
				if(num == 0) result.add(1);
				else result.add(num);
				num = 0;
			}
		}
		Collections.sort(result);
		System.out.println(cnt);
		for(int i : result) {
			System.out.println(i);
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
 	private static void pot(int x, int y, boolean[][] visited) {
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx >= N || ty >=N || tx < 0 || ty < 0) continue;
			if(map[tx][ty] == 0 || visited[tx][ty] == true) continue;
			visited[tx][ty] = true;
			pot(tx, ty, visited);
			num++;
		}
	}

}
