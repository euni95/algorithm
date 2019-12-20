import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO_1113_구급대_3차원방문체크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean[][] map;
	static int[][][] dist;
	static int N, M, endY, endX, ans = Integer.MAX_VALUE;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		endY = Integer.parseInt(st.nextToken());
		endX = Integer.parseInt(st.nextToken());

		int temp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				temp = Integer.parseInt(st.nextToken());
				if (temp == 1)
					map[i][j] = true; // true가 도로
			}
		}

		dist = new int[4][N][M];
		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[k][i], Integer.MAX_VALUE);
			}
		}

		bfs();
		
		for(int i = 0 ; i < 4; i++)
		{
			if(ans>dist[i][endY][endX])ans = dist[i][endY][endX];
		}
		bw.write(ans+"\n");
		bw.close();
	}

	private static void bfs() {
		Queue<Car> q = new LinkedList<>();
		q.offer(new Car(0, 0, 1, 0));
		q.offer(new Car(0, 0, 3, 0));
		dist[1][0][0] = 0;
		dist[3][0][0] = 0;
		int ny, nx, cnt;
		Car car;
		while (!q.isEmpty()) {
			car = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = car.y + dy[i];
				nx = car.x + dx[i];
				cnt = 0;
				if (!isRange(ny, nx))
					continue;
				if (!map[ny][nx])
					continue;

				if (car.dir != i) {
					cnt=1;
				}

				if (dist[i][ny][nx] > dist[car.dir][car.y][car.x] + cnt) {
					dist[i][ny][nx] = dist[car.dir][car.y][car.x] + cnt;
					q.offer(new Car(ny, nx, i, dist[i][ny][nx]));
				}
			}

		}

	}

	private static boolean isRange(int ny, int nx) {
		if (ny < 0 || ny == N || nx < 0 || nx == M)
			return false;
		return true;
	}

	static class Car {
		int y, x, dir, cnt;
		Car(int y, int x, int dir, int cnt) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
}
