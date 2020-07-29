import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_19236_청소년상어 {
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Point[] fish = new Point[17];
		Fish[][] map = new Fish[4][4];
		
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = new Fish(num, dir);
				fish[num] = new Point(i, j);
			}
		}
		moveShark(0, 0, map[0][0].num, map[0][0].dir, copyMap(map), copyFish(fish));
		System.out.println(max);
	}
	
	static int max = 0;
	private static void moveShark(int x, int y, int sum, int dir, Fish[][] map, Point[] fish) {
		map[x][y].dir = 8;

		for(int i = 1; i < 17; i++) {
			Point temp = fish[i];
			int tempDir = map[temp.x][temp.y].dir;
			if(tempDir == 8) continue;
			 
			for(int j = 0; j < 8; j++) {
				int tx = temp.x + dx[(tempDir + j) % 8];
				int ty = temp.y + dy[(tempDir + j) % 8];
				
				if(tx < 0 || ty < 0 || tx >= 4 || ty >= 4) continue;
				if(tx == x && ty == y) continue;
				
				map[temp.x][temp.y].dir = (tempDir + j) % 8;
				swapFish(map[tx][ty], map[temp.x][temp.y], fish[i], fish[map[tx][ty].num]);
				break;
			}
		}
		
		int tx = x;
		int ty = y;
		for(int i = 0; i < 4; i++) {
			tx += dx[dir];
			ty += dy[dir];
			
			if(tx < 0 || ty < 0 || tx >= 4 || ty >= 4) {
				max = Math.max(max, sum);
				break;
			}
			if(map[tx][ty].dir == 8) continue;
			
			moveShark(tx, ty, sum + map[tx][ty].num, map[tx][ty].dir, copyMap(map), copyFish(fish));
		}
	}
	
	public static Fish[][] copyMap(Fish[][] src) {
		Fish[][] dest = new Fish[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				dest[i][j] = new Fish(src[i][j].num, src[i][j].dir);
			}
		}
		return dest;
	}
	
	public static Point[] copyFish(Point[] src) {
		Point[] dest = new Point[17];
		for (int i = 1; i < 17; i++) dest[i] = new Point(src[i].x, src[i].y);
		return dest;
	}
	
	private static void swapFish(Fish a, Fish b, Point num1, Point num2) {
		int tempX = a.num;
		int tempY = a.dir;
		
		a.num = b.num;
		a.dir = b.dir;
		
		b.num = tempX;
		b.dir = tempY;
		
		tempX = num1.x;
		tempY = num1.y;
		
		num1.x = num2.x;
		num1.y = num2.y;
		
		num2.x = tempX;
		num2.y = tempY;
	}

	static class Fish {
		int num, dir;

		public Fish(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}
	}
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
