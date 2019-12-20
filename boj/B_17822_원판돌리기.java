import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17822_원판돌리기 {
	static int N, M, T;
	static ArrayList<Integer>[] pan;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()) + 1; // 원판의 개수
		M = Integer.parseInt(st.nextToken()); // 원판에 적힌 정수의 개수
		T = Integer.parseInt(st.nextToken()); // 회전 수
		
		pan = new ArrayList[N];
		for(int i = 1; i < N; i++) {
			pan[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) pan[i].add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()); // 0 : 시계, 1 : 반시계
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j < N; j++) if(j%num == 0) round(j, dir, cnt);

			System.out.println("회전#######################");
			for(int j = 1; j < N; j++) System.out.println(pan[j]);
			System.out.println();
			
			check = false;
			boolean[][] visited = new boolean[N][M];
			for(int j = 1; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(pan[j].get(k) != 0 && !visited[j][k]) {
						visited[j][k] = true;
						del(visited, j, k, pan[j].get(k));
					}
				}
			}
			
			if(check) {
				System.out.println("제거#######################");
				for(int j = 1; j < N; j++) System.out.println(pan[j]);
				System.out.println();
			}
			
			if(!check) {
				int sum = 0;
				int bojungCnt = 0;
				for(int j = 1; j < N; j++) {
					for(int k = 0; k < M; k++) {
						if(pan[j].get(k) == 0) continue;
						sum += pan[j].get(k);
						bojungCnt++;
					}
				}
				double avg = (double) sum / bojungCnt;
				for(int j = 1; j < N; j++) {
					for(int k = 0; k < M; k++) {
						int temp = pan[j].get(k);
						if(temp == 0) continue;
						if(temp < avg) pan[j].set(k, temp + 1);
						else if(temp > avg) pan[j].set(k, temp - 1);
					}
				}
				
				System.out.println("보정#######################");
				System.out.println(avg);
				for(int j = 1; j < N; j++) System.out.println(pan[j]);
				System.out.println();
			}
			
		}
		
		int result = 0;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M; j++) {
				result += pan[i].get(j);
			}
		}
		System.out.println(result);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean check;
	private static void del(boolean[][] visited, int x, int y, int num) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];
				
				if(tx < 1 || tx >= N) continue;
				if(ty < 0) ty = M - 1;
				if(ty >= M) ty = 0;
				if(visited[tx][ty]) continue;
				if(pan[tx].get(ty) == 0 || pan[tx].get(ty) != num) continue;
				
				check = true;
				visited[tx][ty] = true;
				if(temp.x == x && temp.y == y) pan[x].set(y, 0);
				pan[tx].set(ty, 0);
				q.add(new Point(tx, ty));
			}
		}
	}

	private static void round(int x, int dir, int cnt) {
		if(dir == 0) {
			for(int i = 0; i < cnt; i++) {
				int temp = pan[x].get(M-1);
				pan[x].add(0, temp);
				pan[x].remove(M);
			}
		} else {
			for(int i = 0; i < cnt; i++) {
				int temp = pan[x].get(0);
				pan[x].add(temp);
				pan[x].remove(0);
			}
		}
	}

}
