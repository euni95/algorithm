import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_6109_추억의2048게임 {
	static int N;
	static int[][] tile;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			tile = new int[N][N];
			
			q = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					tile[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			switch(dir) {
			case "up":
				up();
				break;
			case "down":
				down();
				break;
			case "left":
				left();
				break;
			case "right":
				right();
				break;
			}
			System.out.println("#" + t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(tile[i][j] + " ");
				} System.out.println();
			}
		}

	}
	
	static Queue<Integer> q;
	private static void left() {
		for(int i = 0; i < N; i++) {
			int t = 0; // j 인덱스
			for(int j = 0; j < N; j++) {
				if(tile[i][t] == 0) {
					t = t+1;
					continue;
				}
				if(t == j) continue;
				if(tile[i][t] == tile[i][j]) {
					tile[i][t] += tile[i][j];
					tile[i][j] = 0;
					t = j+1;
				}
				if(tile[i][j] != 0) t = j;
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				if(tile[i][j] == 0) {
					int temp = j+1;
					while(true) {
						if(temp >= N) break;
						if(tile[i][temp] != 0) break;
						temp++;
					}
					if(temp >= N) continue;
					tile[i][j] = tile[i][temp];
					tile[i][temp] = 0;
				}
			}
		}
	}

	private static void right() {
		for(int i = N-1; i >= 0; i--) {
			int t = N-1; // j 인덱스
			for(int j = N-1; j >= 0; j--) {
				if(tile[i][t] == 0) {
					t = t-1;
					continue;
				}
				if(t == j) continue;
				if(tile[i][t] == tile[i][j]) {
					tile[i][t] += tile[i][j];
					tile[i][j] = 0;
					t = j-1;
				}
				if(tile[i][j] != 0) t = j;
			}
		}
		for(int i = N-1; i >= 0; i--) {
			for(int j = N-1; j >= 0; j--) {
				if(tile[i][j] == 0) {
					int temp = j-1;
					while(true) {
						if(temp < 0) break;
						if(tile[i][temp] != 0) break;
						temp--;
					}
					if(temp < 0) continue;
					tile[i][j] = tile[i][temp];
					tile[i][temp] = 0;
				}
			}
		}
	}

	private static void down() {
		for(int i = N-1; i >= 0; i--) {
			int t = N-1; // j 인덱스
			for(int j = N-1; j >= 0; j--) {
				if(tile[t][i] == 0) {
					t = t-1;
					continue;
				}
				if(t == j) continue;
				if(tile[t][i] == tile[j][i]) {
					tile[t][i] += tile[j][i];
					tile[j][i] = 0;
					t = j-1;
				}
				if(tile[j][i] != 0) t = j;
			}
		}
		for(int i = N-1; i >= 0; i--) {
			for(int j = N-1; j >= 0; j--) {
				if(tile[j][i] == 0) {
					int temp = j-1;
					while(true) {
						if(temp < 0) break;
						if(tile[temp][i] != 0) break;
						temp--;
					}
					if(temp < 0) continue;
					tile[j][i] = tile[temp][i];
					tile[temp][i] = 0;
				}
			}
		}
	}

	private static void up() {
		for(int i = 0; i < N; i++) {
			int t = 0; // j 인덱스
			for(int j = 0; j < N; j++) {
				if(tile[t][i] == 0) {
					t = t+1;
					continue;
				}
				if(t == j) continue;
				if(tile[t][i] == tile[j][i]) {
					tile[t][i] += tile[j][i];
					tile[j][i] = 0;
					t = j+1;
				}
				if(tile[j][i] != 0) t = j;
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				if(tile[j][i] == 0) {
					int temp = j+1;
					while(true) {
						if(temp >= N) break;
						if(tile[temp][i] != 0) break;
						temp++;
					}
					if(temp >= N) continue;
					tile[j][i] = tile[temp][i];
					tile[temp][i] = 0;
				}
			}
		}
	}
}
