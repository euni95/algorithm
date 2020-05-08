import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12100_2048easy {
	static int N, MAX;
	static int[] order;
	static int[][] origin, pan;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		origin = new int[N][N];
		pan = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		order = new int[5];
		makeOrder(0);
		System.out.println(MAX);
	}

	private static void makeOrder(int idx) {
		if(idx == 5) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					pan[i][j] = origin[i][j];
				}
			}
			game();
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			order[idx] = i;
			makeOrder(idx + 1);
		}
	}

	private static void game() {
		for(int i = 0; i < 5; i++) {
			int dir = order[i];
			move(dir);
		}
	}

	private static void move(int dir) {
		if(dir == 0) { // 상
			for(int i = 0; i < N; i++) { // y좌표, 한 열씩 확인
				int before = 0;
				for(int j = 1; j < N; j++) { // x좌표
					if(pan[j][i] == 0) continue;
					if(pan[before][i] != 0 && pan[before][i] == pan[j][i]) {
						pan[before][i] += pan[j][i];
						pan[j][i] = 0;
					}
					before = j;
				}
				for(int j = 0; j < N; j++) {
					int temp = pan[j][i];
					if(temp == 0) {
						int tempJ = j;
						while(true) {
							tempJ++;
							if(tempJ >= N) break;
							if(pan[tempJ][i] != 0) {
								pan[j][i] = pan[tempJ][i];
								pan[tempJ][i] = 0;
								break;
							}
						}
					}
					MAX = Math.max(pan[j][i], MAX);
				}				
			}
		}
		
		if(dir == 1) { // 하
			for(int i = 0; i < N; i++) {
				int before = N - 1;
				for(int j = N - 2; j >= 0; j--) { 
					if(pan[j][i] == 0) continue;
					if(pan[before][i] != 0 && pan[before][i] == pan[j][i]) {
						pan[before][i] += pan[j][i];
						pan[j][i] = 0;
					}
					before = j;
				}
				for(int j = N - 1; j >= 0; j--) {
					int temp = pan[j][i];
					if(temp == 0) {
						int tempJ = j;
						while(true) {
							tempJ--;
							if(tempJ == -1) break;
							if(pan[tempJ][i] != 0) {
								pan[j][i] = pan[tempJ][i];
								pan[tempJ][i] = 0;
								break;
							}
						}
					}
					MAX = Math.max(pan[j][i], MAX);
				}
			}
		}
		
		if(dir == 2) { // 좌
			for(int i = 0; i < N; i++) { 

				int before = 0;
				for(int j = 1; j < N; j++) {
					if(pan[i][j] == 0) continue;
					if(pan[i][before] != 0 && pan[i][before] == pan[i][j]) {
						pan[i][before] += pan[i][j];
						pan[i][j] = 0;
					}
					before = j;
				}
				for(int j = 0; j < N; j++) {
					int temp = pan[i][j];
					if(temp == 0) {
						int tempJ = j;
						while(true) {
							tempJ++;
							if(tempJ >= N) break;
							if(pan[i][tempJ] != 0) {
								pan[i][j] = pan[i][tempJ];
								pan[i][tempJ] = 0;
								break;
							}
						}
					}
					MAX = Math.max(pan[i][j], MAX);
				}
			}
		}
		
		if(dir == 3) { // 우
			for(int i = 0; i < N; i++) {
				int before = N - 1;
				for(int j = N - 2; j >= 0; j--) {
					if(pan[i][j] == 0) continue;
					if(pan[i][before] != 0 && pan[i][before] == pan[i][j]) {
						pan[i][before] += pan[i][j];
						pan[i][j] = 0;
					}
					before = j;
				}
				for(int j = N - 1; j >= 0; j--) {
					int temp = pan[i][j];
					if(temp == 0) {
						int tempJ = j;
						while(true) {
							tempJ--;
							if(tempJ == -1) break;
							if(pan[i][tempJ] != 0) {
								pan[i][j] = pan[i][tempJ];
								pan[i][tempJ] = 0;
								break;
							}
						}
					}
					MAX = Math.max(pan[i][j], MAX);
				}
			}
		}
	}
}
