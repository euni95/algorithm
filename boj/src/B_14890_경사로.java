import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14890_경사로 {
	static int N, L;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		outer : for(int i = 0; i < N; i++) {
			int before = map[i][0];
			for(int j = 1; j < N; j++) {
				int now = map[i][j];
				
				if(Math.abs(before - now) > 1) continue outer;
				else if(before != now) {
					if(before > map[i][j]) { // [ \ ] 
						if(N - j < L) continue outer;
						for(int k = j; k < j + L; k++) {
							if(map[i][k] != now) continue outer;
							visited[i][k] = true;
						}
					} else { // [ / ]
						if(j - L < 0) continue outer;
						for(int k = j - 1; k >= j - L; k--) {
							if(visited[i][k] || map[i][k] != before) continue outer;
						}
					}
				}
				before = now;
			}
			result++;
		}
		
		visited = new boolean[N][N];
		outer : for(int i = 0; i < N; i++) {
			int before = map[0][i];
			for(int j = 1; j < N; j++) {
				int now = map[j][i];
				
				if(Math.abs(before - now) > 1) continue outer;
				else if(before != now) {
					if(before > map[j][i]) { // [ \ ] 
						if(N - j < L) continue outer;
						for(int k = j; k < j + L; k++) {
							if(map[k][i] != now) continue outer;
							visited[k][i] = true;
						}
					} else { // [ / ]
						if(j - L < 0) continue outer;
						for(int k = j - 1; k >= j - L; k--) {
							if(visited[k][i] || map[k][i] != before) continue outer;
						}
					}
				}
				before = now;
			}
			result++;
		}
		System.out.println(result);
	}
}
