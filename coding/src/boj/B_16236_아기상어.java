import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16236_아기상어 {
	static int N;
	static int[][] space;
	static Point shark;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if (space[i][j] == 9) {
					shark = new Point(i, j, 2);
					space[i][j] = 0;
				}
			}
		}

		eat();
		System.out.println(result);
	}

	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { -1, 0, 0, 1 };
	static int eat, result;
	private static void eat() {
		Point find = find();
		
		if(find != null) {
			result += find.size;

			int findX = find.x, findY = find.y;
			if(shark.size > space[findX][findY]) 
			{
				eat++;
				if(eat == shark.size) {
					shark = new Point(findX, findY, shark.size + 1);
					eat = 0;
				}
				else shark = new Point(findX, findY, shark.size);
				space[findX][findY] = 0;
			} 
			eat();
		}
	}
	static Queue<Point> find = new LinkedList<>();
	private static Point find() {
		boolean[][] visited = new boolean[N][N];
		find.clear();
		visited[shark.x][shark.y] = true;
		find.add(shark);
		int cnt = 0;
		Point re = null;
		while(!find.isEmpty()) {
			int qSize = find.size();
			for(int i = 0; i < qSize; i++) {
				Point temp = find.poll();

				for(int j = 0; j < 4; j++) {
					int tx = temp.x + dx[j];
					int ty = temp.y + dy[j];

					if(tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
					if(visited[tx][ty]) continue;
					if(shark.size < space[tx][ty]) continue;
					visited[tx][ty] = true;
					
					find.add(new Point(tx, ty));
					if(space[tx][ty] != 0 && shark.size != space[tx][ty]) {
						if(re == null) re = new Point(tx, ty);
						else {
							if(re.x == tx) re.setY(Math.min(ty, re.y));
							else {
								if(re.x > tx) re = new Point(tx, ty);
							}
						}
					}
				}
			}
			cnt++;
			if(re != null) {
				re.setSize(cnt);
				return re;
			}
		}
		return null;
	}

	static class Point {
		int x;
		int y;
		int size;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}
		
		public void setSize(int size) {
			this.size = size;
		}

	}
}
