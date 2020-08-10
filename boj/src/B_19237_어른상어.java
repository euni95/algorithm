import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_19237_어른상어 {
	static int N, M, K, time, count;
	static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, -1, 1};
	static int[][] map, shark, smell, cur, order;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 격자 크기
		M = Integer.parseInt(st.nextToken()); // 상어 갯수
		K = Integer.parseInt(st.nextToken()); // 이동 횟수
		
		count = M;
		map = new int[N][N]; // 누가 다녀갔는 ㅈ ㅣ ~?? 냄새 쥔 찾기용
		cur = new int[N][N]; // 지금 몇마리 인지 ~~ !?
		smell = new int[N][N]; // 냄새 몇 초 남았는 지 ~
		shark = new int[M + 1][3]; // 상어 위치랑 방향
		order = new int[4 + (M * 4)][4]; // 상어 방향 우선순위 ~!!
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp != 0) {
					shark[temp][0] = i;
					shark[temp][1] = j;
					smell[i][j] = K;
					cur[i][j] = 1;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= M; i++) {
			shark[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 4; i < 4 + (M * 4); i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				order[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(count != 1 && time <= 1000) {
			for(int i = 1; i <= M; i++) {
				int x = shark[i][0], y = shark[i][1], dir = shark[i][2];
				if(x == -1) continue;
				
				int temp = -1;
				for(int j = 0; j < 4; j++) {
					int td = order[(i * 4) + dir - 1][j];
					int tx = x + dx[td];
					int ty = y + dy[td];
					
					if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
					if(smell[tx][ty] - time <= 0) {
						temp = td;
						break;
					}
				}
				if(temp == -1) {
					for(int j = 0; j < 4; j++) {
						int td = order[(i * 4) + dir - 1][j];
						int tx = x + dx[td];
						int ty = y + dy[td];
						
						if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
						if(map[tx][ty] == i) {
							temp = td;
							break;
						}
					}
				}
				if(temp != -1) {
					int tx = x + dx[temp];
					int ty = y + dy[temp];
					cur[x][y]--;
					cur[tx][ty]++;
					shark[i][0] = tx;
					shark[i][1] = ty;
					shark[i][2] = temp;
				}
			}
			time++;
			for (int i = 1; i <= M; i++) {
				int x = shark[i][0], y = shark[i][1];
				if(x == -1) continue;
				
				if (cur[x][y] > 1) {
					for (int j = i + 1; j <= M; j++) {
						int tx = shark[j][0], ty = shark[j][1];
						if (tx == x && ty == y) {
							cur[x][y]--;
							shark[j][0] = -1;
							count--;
						}
					}
				}
				smell[x][y] = time + K;
				map[x][y] = i;
			}
		}
		System.out.println(time > 1000 ? -1 : time);
	}
}