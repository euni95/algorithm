
public class test {
	static Point test;
	public static void main(String[] args) {
		test = new Point(3, 3);
		System.out.println(test);
		move(test);
		System.out.println(test);
	}

	private static void move(Point sdd) {
		sdd.x = 7;
	}
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
}
